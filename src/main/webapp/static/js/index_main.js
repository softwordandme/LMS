$(function () {
    var setl=0;
    var css = {left:'-1210px'};
    setInterval(function(){
        $("table").animate(css,1000,rowBack);
        setl++;
    },4000);
    function rowBack(){
        if(setl%6<3){
            css.left=-1220-setl%6*1210+"px";
        }
        else{
            css.left=-1210*3-10+(setl%6-2)*1210+"px";
        }

    }
});