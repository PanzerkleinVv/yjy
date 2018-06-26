<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mainContent">
	<div class="infoMethod">网站参数</div>
	<div style="color:${msg0};">${msg}</div>
	<c:set var="i" />
	<c:forEach var="preference" items="${preferences}" varStatus="status">
		<div>
			<span>${preference.name}</span> <span><input
				name="${preference.id}" id="${preference.id}"
				value="${preference.value}" class="form-control placeholder-no-fix"
				onblur="check(${preference.id})" /></span>
		</div>
		<div id='msg${preference.id}' style='display: none;'></div>
		<c:set var="i" value="${preference.id}" />
	</c:forEach>
	<div class="infoButton">
		<button id="saveBut" type="button" class="btn blue">保存参数</button>
	</div>
	<script type="text/javascript">
		var count = ${i};
		function check(id) {
			var item = $('#msg'+id);
			var value = $('#'+id).val();
			if (value == null || value.length == 0) {
				item.css('display', 'block');
				item.css('color', '#FF0000');
				item.html('不能为空');
				return false;
			}  else {
				item.css('display', 'block');
				item.css('color', '#00FF00');
				item.html('OK');
				return true;
			}
		}
		$('#saveBut').click(function() {
			var url = 'rest/preference/save';
			var pass = false;
			//var data0 = [];
			for(var i = 1; i < count+1; i++) {
				pass = check(i);
			//	data0.push({"id": i ,"value": $('#'+i).val()});
			}
			var data0 = {name : $("#1").val(), title : $("#2").val(), keywords : $("#3").val(), description : $("#4").val(), aboutme : $("#5").val()}
			if (pass) {
				$.ajax({
					url : url,
					type : "POST",
					data : data0,
					success : function(data) {
						$('#main-content').html(data);
					}
				});
			}
		});
		$('form').keypress(function(e) {
			var keynum;
			if (window.event) // IE
			{
				keynum = e.keyCode;
			} else if (e.which) // Netscape/Firefox/Opera
			{
				keynum = e.which;
			}
			if (keynum == 13) {
				return false;
			}
		});

		$(function() {
			$("#index-page-title").html("网站参数");
			$("#current-page-title").html("网站参数");
		});
	</script>
</div>