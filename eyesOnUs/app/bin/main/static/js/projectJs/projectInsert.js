const insertPmVal = document.querySelector("#insertPm").value;

if(insertPmVal == 10){
    function smt(){
        const titleVal = document.querySelector("#title").value;
        const codeVal = document.querySelector("#code").value;
        const empVal = document.querySelector("#emp").value;
        const stateVal = document.querySelector("#state").value;
        const contentVal = document.querySelector("#projectContent").value;
    
        titleVal != null ? titleVal : alert("제목을 입력하세요");
        contentVal != null ? contentVal : alert("제목을 입력하세요");


        $.ajax({
            url : '/project/projectInsert',
            type : 'post',
            data : {
                title : titleVal,
                code : codeVal,
                empNo : empVal,
                stateANo : stateVal,
                content : contentVal
            },
            success : function(x){
                alert("등록완료!");
                location.href='/project/projectMain';
            },
            error : function(x){
                console.log("에러")
            }
        });
    }
}