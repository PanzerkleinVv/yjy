<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mainContent sortable">
	<div class="infoMethod">栏目管理</div>
	<c:forEach var="column" items="${columns}" varStatus="status">
		<div id="${column.id}" class="columnLine sortableLine">
			<span class="columnSpanContent"> <span class="columnName">${column.columnName}<c:if
						test="${column.columnStatus == 0}">（已停用）</c:if>
			</span> <span class="columnForm"><span>栏目名：</span><input type="text"
					id="${column.id}_name" value="${column.columnName}"
					class="form-control placeholder-no-fix" onblur="check(this)" /></span> <span
				class="columnForm"><span>栏目title：</span><input type="text"
					id="${column.id}_title" value="${column.columnTitle}"
					class="form-control placeholder-no-fix" onblur="check(this)" /></span> <span
				class="columnForm"><span>栏目keyword：</span><input type="text"
					id="${column.id}_keyword" value="${column.columnKeyword}"
					class="form-control placeholder-no-fix" onblur="check(this)" /></span> <span
				class="columnForm"><span>栏目description：</span><input
					type="text" id="${column.id}_info" value="${column.columnInfo}"
					class="form-control placeholder-no-fix" onblur="check(this)" /></span> <input
				type="hidden" name="ids" value="${column.id}" /><span id="msg"
				class="columnForm"></span>
			</span> <span class="columnSpanButton"><button id="editBut"
					type="button" class="btn blue columnNormal"
					onclick="edit('${column.id}')">修改</button>
				<button id="saveBut" type="button" class="btn blue columnForm"
					onclick="save('${column.id}')">保存</button> <c:choose>
					<c:when test="${column.columnStatus == 1}">
						<button id="stopBut" type="button" class="btn red columnForm"
							onclick="stop('${column.id}')">停用</button>
						<button id="startBut" type="button"
							class="btn green columnForm columnStatus"
							onclick="start('${column.id}')">启用</button>
					</c:when>
					<c:otherwise>
						<button id="stopBut" type="button"
							class="btn red columnForm columnStatus"
							onclick="stop('${column.id}')">停用</button>
						<button id="startBut" type="button" class="btn green columnForm"
							onclick="start('${column.id}')">启用</button>
					</c:otherwise>
				</c:choose>
				<button id="cancelBut" type="button" class="btn red columnForm"
					onclick="cancel('${column.id}')">取消</button></span>
		</div>
	</c:forEach>
	<div id="add" class="columnLine">
		<span class="columnSpanContent"> <span class="columnName">新增栏目
		</span> <span class="columnForm"><span>栏目名：</span><input type="text"
				id="add_name" value="" class="form-control placeholder-no-fix"
				onblur="check(this)" /></span> <span class="columnForm"><span>栏目title：</span><input
				type="text" id="add_title" value=""
				class="form-control placeholder-no-fix" onblur="check(this)" /></span> <span
			class="columnForm"><span>栏目keyword：</span><input type="text"
				id="add_keyword" value="" class="form-control placeholder-no-fix"
				onblur="check(this)" /></span> <span class="columnForm"><span>栏目description：</span><input
				type="text" id="add_info" value=""
				class="form-control placeholder-no-fix" onblur="check(this)" /></span> <input
			type="hidden" name="ids" value="" /><span id="msg"
			class="columnForm"></span>
		</span> <span class="columnSpanButton"><button id="editBut"
				type="button" class="btn blue columnNormal" onclick="edit('add')">新增</button>
			<button id="saveBut" type="button" class="btn blue columnForm"
				onclick="save('add')">保存</button>
			<button id="cancelBut" type="button" class="btn red columnForm"
				onclick="cancel('add')">取消</button></span>
	</div>
	<div style="color:${msg0};" id="sortMsg">${msg}</div>
	<div class="infoButton">
		<button id="sortBut" type="button" class="btn blue">保存排序</button>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".sortable").sortable({
				cursor : "move",
				items : ".columnLine",
				opacity : 0.8,
				placeholder : "sortableLine"
			});
		});

		function edit(id) {
			if (id == 'add') {
				$('#' + id + "_name").val("");
				$('#' + id + "_title").val("");
				$('#' + id + "_keyword").val("");
				$('#' + id + "_info").val("");
				$('#' + id + " .columnNormal").hide("fast");
				$('#' + id + " .columnForm").show("fast");
			} else {
				var url = 'rest/column/getOne';
				$.getJSON(url, {
					'id' : $('#' + id + " input[name='ids']").val()
				}, function(data) {
					$('#' + id + " .columnName").html(data.columnName);
					if (data.columnStatus == 0) {
						$('#' + id + " .columnName").append("（已停用）");
					}
					$('#' + id + "_name").val(data.columnName);
					$('#' + id + "_title").val(data.columnTitle);
					$('#' + id + "_keyword").val(data.columnKeyword);
					$('#' + id + "_info").val(data.columnInfo);
					$('#' + id + " .columnNormal").hide("fast");
					$('#' + id + " .columnForm").show("fast");
				});
			}
		}

		function cancel(id) {
			$('#' + id + " .columnNormal").show("fast");
			$('#' + id + " .columnForm").hide("fast");
		}

		function save(id) {
			if (check($('#' + id + "_name").get(0))) {
				if (check($('#' + id + "_title").get(0))) {
					if (check($('#' + id + "_keyword").get(0))) {
						if (check($('#' + id + "_info").get(0))) {
							if (id == 'add') {
								var url = 'rest/column/add';
								$.get(url, {
									'columnName' : $('#' + id + "_name").val(),
									'columnTitle' : $('#' + id + "_title")
											.val(),
									'columnKeyword' : $('#' + id + "_keyword")
											.val(),
									'columnInfo' : $('#' + id + "_info").val()
								}, function(data) {
									$('#main-content').html(data);
								});
							} else {
								var url = 'rest/column/save';
								$.getJSON(url, {
									'id' : $('#' + id + " input[name='ids']")
											.val(),
									'columnName' : $('#' + id + "_name").val(),
									'columnTitle' : $('#' + id + "_title")
											.val(),
									'columnKeyword' : $('#' + id + "_keyword")
											.val(),
									'columnInfo' : $('#' + id + "_info").val()
								},
										function(data) {
											$('#' + id + "_name").val(
													data.columnName);
											$('#' + id + " .columnName").html(
													data.columnName);
											if (data.columnStatus == 0) {
												$('#' + id + " .columnName")
														.append("（已停用）");
											}
											$('#' + id + "_title").val(
													data.columnTitle);
											$('#' + id + "_keyword").val(
													data.columnKeyword);
											$('#' + id + "_info").val(
													data.columnInfo);
											$('#' + id + " .columnNormal")
													.show("fast");
											$('#' + id + " .columnForm").hide(
													"fast");
											$('#' + id + " #msg").css(
													'display', 'block');
											$('#' + id + " #msg").css('color',
													data.msg0);
											$('#' + id + " #msg")
													.html(data.msg);
										});
							}
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		function start(id) {
			var url = 'rest/column/start';
			$.getJSON(url, {
				'id' : $('#' + id + " input[name='ids']").val()
			}, function(data) {
				$('#' + id + "_name").val(data.columnName);
				$('#' + id + " .columnName").html(data.columnName);
				if (data.columnStatus == 0) {
					$('#' + id + " .columnName").append("（已停用）");
				}
				$('#' + id + "_title").val(data.columnTitle);
				$('#' + id + "_keyword").val(data.columnKeyword);
				$('#' + id + "_info").val(data.columnInfo);
				if (data.msg.indexOf("成功") > -1) {
					$('#' + id + " #stopBut").toggleClass('columnStatus');
					$('#' + id + " #startBut").toggleClass('columnStatus');
				}
				$('#' + id + " .columnNormal").show("fast");
				$('#' + id + " .columnForm").hide("fast");
				$('#' + id + " #msg").css('display', 'block');
				$('#' + id + " #msg").css('color', data.msg0);
				$('#' + id + " #msg").html(data.msg);
			});
		}

		function stop(id) {
			var url = 'rest/column/stop';
			$.getJSON(url, {
				'id' : $('#' + id + " input[name='ids']").val()
			}, function(data) {
				$('#' + id + "_name").val(data.columnName);
				$('#' + id + " .columnName").html(data.columnName);
				if (data.columnStatus == 0) {
					$('#' + id + " .columnName").append("（已停用）");
				}
				$('#' + id + "_title").val(data.columnTitle);
				$('#' + id + "_keyword").val(data.columnKeyword);
				$('#' + id + "_info").val(data.columnInfo);
				if (data.msg.indexOf("成功") > -1) {
					$('#' + id + " #stopBut").toggleClass('columnStatus');
					$('#' + id + " #startBut").toggleClass('columnStatus');
				}
				$('#' + id + " .columnNormal").show("fast");
				$('#' + id + " .columnForm").hide("fast");
				$('#' + id + " #msg").css('display', 'block');
				$('#' + id + " #msg").css('color', data.msg0);
				$('#' + id + " #msg").html(data.msg);
			});
		}

		function check(target) {
			var value = $(target).val();
			var item = $(target).parent().parent().children("#msg");
			var targetName = $(target).prev().html();
			if (value == null || value.length == 0) {
				item.css('display', 'block');
				item.css('color', '#FF0000');
				item.html(targetName + '不能为空');
				return false;
			} else {
				item.html('');
				return true;
			}
		}

		$('#sortBut').click(function() {
			var url = 'rest/column/sort';
			var ids = $("input[name='ids']").map(function() {
				return $(this).val();
			}).get();
			$.ajax({
				'type' : 'POST',
				'url' : url,
				'data' : {
					'ids' : ids
				},
				'dataType' : 'json',
				'success' : function(data) {
					$('#sortMsg').css('display', 'block');
					$('#sortMsg').css('color', data.msg0);
					$('#sortMsg').html(data.msg);
				},
			});
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
			$("#index-page-title").html("栏目管理");
			$("#current-page-title").html("栏目管理");
		});
	</script>
</div>