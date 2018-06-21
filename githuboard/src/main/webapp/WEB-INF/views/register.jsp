<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <!-- Bootstrap core JavaScript -->
    <script src="./resources/vendor/jquery/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<style>
span{
	color:red;
}
</style>
<body>

	<section class="content">
	<div class="box">
		<form method="post" onsubmit='return check()'>
			이메일:<input type="email" 
			id="email" name="email" required="required" />
			<span id="emailspan"></span><br />
			비밀번호:<input type="password" 
			id="password" name="password" required="required" />
			<br />
			별명:<input type="text" 
			id="nickname" name="nickname" required="required" />
			<span id="nicknamespan"></span><br />
			<input type="submit" value="회원가입" />
		</form>
	</div>
</section>
	
	
</body>
<script>
	//이메일 중복검사와 닉네임 중복검사 여부를 저장하기 위한 변수 생성
	var emailcheck=false;
	var nicknamecheck=false;
	
	var emailspan = document.getElementById('emailspan');
	var nicknamespan = document.getElementById('nicknamespan');
	//이메일 중복검사
	document.getElementById("email").addEventListener(
		'blur',function(){
			$.ajax({
				url:"emailcheck",
				data:{'email':document.getElementById('email').value},
				success:function(data){
					if(data.result == 'null'){
						emailspan.innerHTML="사용 가능한 이메일";
						emailspan.style.color='blue';
						emailcheck = true;
					}else{
						emailspan.innerHTML="사용 불 가능한 이메일";
						emailspan.style.color='red';
						emailcheck = false;
					}
				}
			});
	});
	
	//닉네임 중복검사
	document.getElementById("nickname").addEventListener(
		'blur',function(){
			$.ajax({
				url:"nicknamecheck",
				data:{'nickname':document.getElementById('nickname').value},
				success:function(data){
					if(data.result == 'null'){
						nicknamespan.innerHTML="사용 가능한 별명";
						nicknamespan.style.color='blue';
						nicknamecheck = true;
					}else{
						nicknamespan.innerHTML="사용 불 가능한 별명";
						nicknamespan.style.color='red';
						nicknamecheck = false;
					}
				}
			});
	});
	
	//회원가입을 눌렀을 때 유효성 검사를 위한 함수
	function check(){
		if(emailcheck == false){
			emailspan.innerHTML="이메일 중복 검사를 해야 합니다.";
			emailspan.style.color='red';
			return false;
		}
		if(nicknamecheck == false){
			nicknamespan.innerHTML="닉네임 중복 검사를 해야 합니다.";
			nicknamespan.style.color='red';
			return false;
		}
	}

</script>

</html>