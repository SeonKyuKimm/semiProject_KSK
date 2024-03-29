const checkObj ={
    "inputId" : false,
    "inputPw" : false,
    "inputPwConfirm" : false,
    "inputName" : false
};
// surf
// ID 유효성 검사
const inputId = document.getElementById("inputId");

inputId.addEventListener("keyup", function() {

    const regExp = /^[a-z][\w]{5,13}$/;

    if( regExp.test(this.value)){
        this.style.backgroundColor = "lightgreen";
        this.style.color = "white";
        checkObj.inputId = true;
    }else{
        this.style.backgroundColor = "pink";
        this.style.color = "white";
        checkObj.inputId = false;
    }

});

// 비밀번호 유효성 검사
const inputPw = document.getElementById("inputPw");
const inputPwConfirm = document.getElementById("inputPw2");

inputPwConfirm.addEventListener("keyup", function(){

    if(inputPw.value.length ==0 ){
        this.value="";
        alert("비밀번호를 먼저 입력하세용");
        inputPw.focus();
        checkObj.inputPw = false;
    }
});

const pwMessage = document.getElementById("pwMessage");

inputPw.addEventListener("keyup", function(){

    if( (inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0 ){
        pwMessage.innerText="비밀번호 일치"; // span태그 빈칸 
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");
        checkObj.inputPw = true;
        checkObj.inputPwConfirm = true;
    }else{
        pwMessage.innerText="비밀번호 불일치ㅜㅜ"; // span태그 빈칸 
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
        
        checkObj.inputPwConfirm = false;
    }

});

inputPwConfirm.addEventListener("keyup", function(){

    if((inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0){
        pwMessage.innerText="비밀번호 일치"; // span태그 빈칸 
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");
        checkObj.inputPw = true;
        checkObj.inputPwConfirm = true;
    }else{
        pwMessage.innerText="비밀번호 불일치ㅜㅜ"; // span태그 빈칸 
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
        
        checkObj.inputPwConfirm = false;
    }

});

// 닉네임 검사
const inputName = document.getElementById("inputName");

inputName.addEventListener("change", function(){

    const regExp = /^[가-힣]{2,5}$/;
    const nameMessage = document.getElementById("nameMessage");

    if(regExp.test(this.value)){
        nameMessage.innerText="정상적으로 입력되었습니다-";
        nameMessage.classList.add("confirm");
        nameMessage.classList.remove("error");
        checkObj.inputName = true;
    }else{
        nameMessage.innerText="2 -5 글자 사이 한글만 입력하세요";
        nameMessage.classList.add("error");
        nameMessage.classList.remove("confirm");
        checkObj.inputName = false;
    }

});

function validate(){

    for(let key in checkObj){
        if(!checkObj[key] ){
            alert("유효성 검사가 완료되지 않았으용");
            return false;
        }
    }
    return true;
}