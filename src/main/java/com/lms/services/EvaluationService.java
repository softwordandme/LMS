package com.lms.services;


import com.lms.dao.*;
import com.lms.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EvaluationService {

    @Autowired
    EvaluationDao evaluationDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    ClazzDao clazzDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    TermDao termDao;
    @Autowired
    TeacherDao teacherDao;

    /**
     * 保存评教*/
    public String evaluationScoreDo(String evaluationJudgesId, String evaluationPlayerId, BigDecimal score,Integer termId,Integer courseId){
        Evaluation evaluation = new Evaluation();

        if (courseId != null){
            //获取评教人
            Student student = studentDao.findStudentByStudentNo(evaluationJudgesId);

            Integer clazzNum = student.getClazzNum();
            evaluation.setClazzNum(clazzNum);
            evaluation.setCourseId(courseId);
        }
        evaluation.setEvaluationJudgesId(evaluationJudgesId);
        evaluation.setEvaluationPlayerId(evaluationPlayerId);
        evaluation.setScore(score);
        evaluation.setEvaluationTremId(termId);
        evaluationDao.save(evaluation);
        return "true";
    }

    /**
     * 根据课程id和班级id获取评教
     */
    public Map<String,Integer> findEvaluationByCourseIdAndClazzNumAndEvaluationJudgesId(Integer courseId,Integer clazzNum,String evaluationJudgesId){
        Evaluation e= evaluationDao.findEvaluationByCourseIdAndClazzNumAndEvaluationJudgesId(courseId,clazzNum,evaluationJudgesId);
        Map<String,Integer> sign = new HashMap<>(16);
            if (e !=null ){
                sign.put("w"+courseId+"w"+clazzNum,1);
            }else{
                sign.put("w"+courseId+"w"+clazzNum,0);
            }
        return sign;
    }

    /**
     * 通过课程和班级得到评教数
     */
    public Integer countEvaluationsByCourseIdAndClazzNum(Integer courseId,Integer clazzNum){
        return evaluationDao.countEvaluationsByCourseIdAndClazzNum(courseId,clazzNum);
    }

    /**
     * 通过系主任评教TeacherNo和被评教师TeacherNo的和学期termId获取评价
     */
    public Evaluation findEvaluationByEvaluationJudgesIdAndEvaluationPlayerIdAndEvaluationTremId(String evaluationJudgesId,String evaluationPlayerId,Integer termId){
        return evaluationDao.findEvaluationByEvaluationJudgesIdAndEvaluationPlayerIdAndEvaluationTremId(evaluationJudgesId,evaluationPlayerId,termId);
    }

    /**
     * 根据学期和teacherNo获取对教师的评教内容*/
    public List<Evaluation> findEvaluationByTeacherNoAndTermId(Integer termId,String teacherNo){
        List<Course> courses = courseDao.findCoursesByTermId(termId);
        List<Evaluation> evaluations = new ArrayList<>();
        List<Evaluation> evaluationOld;
        for (Course c:courses){
                Evaluation evaluation = new Evaluation();
                //通过课程得到开设这门课程的班级
                List<Clazz> clazzes = clazzDao.findClazzesByCourseId(c.getCourseId());
                for (Clazz clazz:clazzes){
                    //得到班级
                    Integer clazzNum = clazz.getClazzNum();
                    Integer courseId = c.getCourseId();
                    //通过登陆的教师No、教师的课程和班级查询评教分数
                    evaluationOld = evaluationDao.findEvaluationsByEvaluationPlayerIdAndCourseIdAndClazzNum(teacherNo,courseId,clazzNum);
                    int num = 0;
                    int mm = 1;
                    BigDecimal allScore = new BigDecimal(0);
                    for (Evaluation e:evaluationOld){

                        if (mm==1){
                            evaluation = e;
                            mm = 0;
                        }
                        BigDecimal score = e.getScore();
                        allScore = allScore.add(score);
                        num++;
                    }
                    if (num!=0){
                        BigDecimal numBD = new BigDecimal(num);
                        evaluation.setScore(allScore.divide(numBD));
                    }
                }
            evaluations.add(evaluation);
        }
        return evaluations;
    }

    /**
     * 获取当前学期
     */
    public Term findTermByStatus(){
        Integer status = 1;
        Term term = termDao.findTermByStatus(status);
        return term;
    }

    /**
     * 标识是否评价
     */
    public Map<String,Integer> teacherSign(List<Teacher> teacherList,String evaluationJudgesId,Integer termId){
        Map<String,Integer> sign = new HashMap<>(16);
        for (Teacher t:teacherList){
            Evaluation evaluation = evaluationDao.findEvaluationByEvaluationJudgesIdAndEvaluationPlayerIdAndEvaluationTremId(evaluationJudgesId,t.getTeacherNo(),termId);
            if (evaluation != null){
                sign.put("w"+t.getTeacherNo(),1);
            }else{
                sign.put("w"+t.getTeacherNo(),0);
            }
        }
        return sign;
    }

}
