package com.lms.controller;

import com.lms.po.*;
import com.lms.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author zz
 * @date 2018/10/8
 */
@Controller
public class EvaluationTimeController {
    @Autowired
    EvaluationTimeService evaluationTimeService;
    @Autowired
    EvaluationTypeService evaluationTypeService;
    @Autowired
    RoleService roleService;
    @Autowired
    TermService termService;
    @Autowired
    EvaluationService evaluationService;


    @RequestMapping(value = "evaluationTimeManagement")
    public String EvaluationTimeManagement(HttpServletRequest request){
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        if (userId==null){
            return "error_no_login";
        }
        List<EvaluationTime> evaluationTimes = evaluationTimeService.findEvaluationTimeAll();
        List<EvaluationTime> evaluationTimesList = new ArrayList<>();
        for (int i=0;i<evaluationTimes.size();i++){
            EvaluationTime evaluationTime = evaluationTimeService.findEvaluationTimeByEvaluationTimeId(evaluationTimes.get(i).getEvaluationTimeId());
            if (evaluationTime != null){
                evaluationTimesList.add(evaluationTime);
            }
        }
        for(EvaluationTime e:evaluationTimesList){
            if (e != null){
                Integer roleId =evaluationTypeService.findEvaluationTypeAllByevaluationTypeId(e.getEvaluationTypeId()).getRoleId();
                e.setRoleName(roleService.findByRoleId(Integer.toString(roleId)).getRoleName());
            }
        }

        for (int n=0;n<evaluationTimesList.size();n++){
            if (evaluationTimesList.get(n) != null){
                evaluationTimesList.get(n).setTermName(termService.findAllBytermId(evaluationTimes.get(n).getTermId()).getTermName());
            }
        }
        request.setAttribute("evaluationTimesList", evaluationTimesList);
        return "teachManagement/evaluationTimeManagement";
    }
    @RequestMapping("ToAddETM")
    public String toAddETM(HttpServletRequest request){
        //加载学年学期
        Term term = evaluationService.findTermByStatus();
        request.setAttribute("term",term);

        List<EvaluationTime> evaluationTimes = evaluationTimeService.findEvaluationTimeAll();
        List<EvaluationTime> evaluationTimesList = new ArrayList<>();
        List<EvaluationType> evaluationTypes = evaluationTypeService.findAll();

        List<Role> roleList = new ArrayList<>();
        for (int i=0;i<evaluationTimes.size();i++){
            EvaluationTime evaluationTime = evaluationTimeService.findEvaluationTimeByEvaluationTimeId(evaluationTimes.get(i).getEvaluationTimeId());
            if (evaluationTime != null){
                evaluationTimesList.add(evaluationTime);
            }
        }
        for(int j=0;j<evaluationTypes.size();j++){
            Role role = roleService.findByRoleId(Integer.toString(evaluationTypes.get(j).getRoleId()));
            roleList.add(role);
        }
        request.setAttribute("roleList",roleList);
        request.setAttribute("evaluationTimesList", evaluationTimesList);
        return "teachManagement/addETM";
    }
    @RequestMapping("addETM")
    public String addETM(EvaluationTime evaluationTime,String evaluationStartin,String evaluationEndin,Integer roleId) throws ParseException {
        EvaluationType evaluationType = evaluationTypeService.findAllByRoleId(roleId);
        Integer evaluationTypeId = evaluationType.getEvaluationTypeId();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        evaluationTime.setEvaluationStart(format.parse(evaluationStartin));
        evaluationTime.setEvaluationEnd(format.parse(evaluationEndin));
        evaluationTime.setEvaluationTypeId(evaluationTypeId);
        EvaluationTime et = evaluationTimeService.addEvaluation(evaluationTime);
        return "redirect:"+"/evaluationTimeManagement";

    }
    @RequestMapping("ToUpdateETM")
    public String updateETM(HttpServletRequest request, Integer evaluationTimeId){
        EvaluationTime evaluationTime = evaluationTimeService.findEvaluationTimeByEvaluationTimeId(evaluationTimeId);
        //加载学年学期
        Term term = evaluationService.findTermByStatus();

        request.setAttribute("evaluationTimeId",evaluationTimeId);
        request.setAttribute("term",term);
        EvaluationType evaluationType = evaluationTypeService.findEvaluationTypeAllByevaluationTypeId(evaluationTime.getEvaluationTypeId());
        request.setAttribute("evaluationType",evaluationType);
        List<Role> roles = roleService.findAllRole();
        request.setAttribute("roles",roles);
        return "teachManagement/updateETM";
    }
    @RequestMapping("updateETM")
    public String updateETM(Integer evaluationTimeId,String evaluationStartin,String evaluationEndin,Integer roleId) throws ParseException {
        EvaluationTime evaluationTime = evaluationTimeService.findEvaluationTimeByEvaluationTimeId(evaluationTimeId);
        EvaluationType evaluationType = evaluationTypeService.findAllByRoleId(roleId);
        Integer evaluationTypeId = evaluationType.getEvaluationTypeId();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        evaluationTime.setEvaluationStart(format.parse(evaluationStartin));
        evaluationTime.setEvaluationEnd(format.parse(evaluationEndin));
        evaluationTime.setEvaluationTypeId(evaluationTypeId);
        EvaluationTime et = evaluationTimeService.updateEvaluation(evaluationTime);
        return "redirect:"+"/evaluationTimeManagement";

    }
    @RequestMapping("StartETM")
    public String startETM(Integer evaluationTimeId){
        EvaluationTime evaluationTime = evaluationTimeService.findEvaluationTimeByEvaluationTimeId(evaluationTimeId);
        EvaluationType evaluationType = evaluationTypeService.findEvaluationTypeAllByevaluationTypeId(evaluationTime.getEvaluationTypeId());
        if (evaluationType.getEvaluationTypeId() != null){
            evaluationType.setStatus(1);
            evaluationTypeService.updateStatus(evaluationType);
        }
        return "redirect:"+"/evaluationTimeManagement";
    }
    @RequestMapping("StopETM")
    public String stopETM(Integer evaluationTimeId){
        EvaluationTime evaluationTime = evaluationTimeService.findEvaluationTimeByEvaluationTimeId(evaluationTimeId);
        EvaluationType evaluationType = evaluationTypeService.findEvaluationTypeAllByevaluationTypeId(evaluationTime.getEvaluationTypeId());
        if (evaluationType.getEvaluationTypeId() != null){
            evaluationType.setStatus(0);
            evaluationTypeService.updateStatus(evaluationType);
        }
        return "redirect:"+"/evaluationTimeManagement";
    }
    @RequestMapping("DeleteETM")
    public String deleteETM(Integer evaluationTimeId){
        evaluationTimeService.deleteEvaluationTime(evaluationTimeId);
        return "redirect:"+"/evaluationTimeManagement";
    }
}
