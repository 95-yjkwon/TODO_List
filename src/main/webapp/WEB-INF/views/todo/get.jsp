<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-lg-10">
			<h1 class="page-header">게시글 상세조회</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-10">
			<div class="panel panel-default">
				<div class="panel-heading">Board Register</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-10">

							<div class="form-group">
								<label>번호</label> <input class="form-control" name="tno"
									value="${todo.tno}" readonly>

							</div>
							<div class="form-group">
								<label>작성자</label> <input class="form-control" name="writer"
									value="${todo.writer}" readonly>
							</div>
							<div class="form-group">
								<label>해야 할 일</label> <input class="form-control" name="title"
									value="${todo.title}" readonly>

							</div>

							<div class="form-group">
								<label>마감일</label> <input class="form-control" type="date"
									name="dueDate"
									value='<fmt:formatDate pattern="yyyy-MM-dd" value="${todo.dueDate}"/>'
									readonly>
							</div>
							<div class="form-group">

								<div class="form-group">
									<label>수행여부</label> <input class="form-control" type="text"
										name="finished" value="${todo.finished == 0 ? '미완료' : '완료'}"
										readonly>
								</div>

								<div class="form-group">
									<label>등록일</label> <input class="form-control" type="date"
										name="regdate"
										value='<fmt:formatDate pattern="yyyy-MM-dd" value="${todo.regdate}"/>'
										readonly>
								</div>


								<%-- 	<button data-oper='modify' class="btn btn-default"
								onclick="location.href='/board/modify?bno=${board.bno}'">글
								수정</button>
							<button data-oper='list' class="btn btn-info" onclick="location.href='/board/list'">목록</button>
                                   --%>
								<button data-oper='modify' class="btn btn-default">수정</button>
								<button data-oper='list' class="btn btn-info">목록</button>

								<!-- 페이지 이동 처리를 위한 수정 -->
								<form id="operForm" action="/board/modify" method="GET">
									<input type="hidden" id="tno" name="tno" value="${todo.tno}" />

								</form>
							</div>
							<!-- /.col-lg-6 (nested) -->

						</div>
						<!-- /.row (nested) -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>

		<script type="text/javascript">
			const operForm = $("#operForm");

			$("button[data-oper='modify']").on("click", function(e) {
				operForm.attr("action", "/todo/modify").submit();
			});
			$("button[data-oper='list']").on("click", function(e) {
				operForm.find("#tno").remove();
				operForm.attr("action", "/todo/list");
				operForm.submit();
			})
		</script>

		<%@ include file="../includes/footer.jsp"%>
</body>
</html>