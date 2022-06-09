<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 첨부형 게시판</title>
<script type="text/javascript">

	//글쓰기 폼에서 누락된 내용이 있는지 확인하는 함수
	function validateForm(form) {
		if (form.name.value ==""){
			alert("작성자를 입력하세요.");
			form.name.focus();
			return false;
		}
		if (form.title.value == ""){
			alert("제목을 입력하세요.");
			form.title.focus();
			return false;
		}
		if (form.content.value == ""){
			alert("내용을 입력하세요.");
			form.content.focus();
			return false;
		}
		/* if (form.pass.value == ""){
			alert("비밀번호를 입력하세요.");
			form.pass.focus();
			return false;
		} */
	}
</script>
</head>
<body>
	<h2>파일 첨부형 게시판- 수정하기(Edit)</h2>
	
	<!-- 게시물 수정을 위해 일련번호와 기존 파일명을 hidden 박스에 추가한다. -->
	<form action="../mvcboard/edit.do" name="writeFrm" method="post"
	enctype="multipart/form-data" onsubmit="return validateForm(this)">
	<!-- 게시물 수정을 위해 일련번호와 기존 파일명을 hidden박스에 추가한다. -->
	<input type="hidden" name="idx" value="${dto.idx }" />
	<!-- 기존의 원본파일명 -->
	<input type="hidden" name="prevOfile" value="${dto.ofile }" />
	<!-- 서버에 저장된 파일명 -->
	<input type="hidden" name="prevSfile" value="${dto.sfile }" />
	
	
	검증된패스워드:${pass }
	<table border="1" width="90%">
	<tr>
		<td>작성자</td>
		<td>
			<input type="text" name="name" style="width:150px;" value="${dto.name }"/>
		</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>
			<input type="text" name="title" style="width:90%;" value="${dto.title }"/>
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea name="content" style="width:90%;height:100px;"/>${dto.content }</textarea>
		</td>
	</tr>
	<tr>
		<td>첨부파일</td>
		<td>
			<input type="file" name="ofile" />
		</td>
	</tr>
	<tr>
		<td>첨부 파일 삭제하기</td>
		<td>
			<input type="checkbox" name="check" value="1" />
		</td>
	</tr>
	<!-- 패스워드 검증을 마친후 수정페이지로 진입하였으므로 비밀번호
	입력창은 화면에서 제거한다. -->
	<!-- <tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="pass" style="width:100px;"/>
		</td>
	</tr> -->
	<tr>
		<td colspan="2" align="center">
			<button type="submit">작성 완료</button>
			<button type="reset">RESET</button>
			<button type="button" onclick="location.href='../mvcboard/list.do;'">
				목록 바로가기
			</button>
		</td>
	</tr>
	</table>
	</form>
</body>
</html>