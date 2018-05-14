<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="mainContent">
	<div class="articleList">
		<div class="infoMethod">文章管理</div>
		<div>
			<select id="queryColumn">
				<option></option>
				<c:forEach var="column" items="{columns}">
					<option value="${column.id}"
						<c:if test="${queryColumn eq column.id}">selected="selected"</c:if>>${column.column.Name}</option>
				</c:forEach>
			</select>
		</div>
		<c:forEach var="article" items="${articles}" varStatus="status">
			<div id="${article.id}" class="articleLine sortableLine">
				<span class="articleSpanContent"> <span class="articleName">${article.articleName}
				</span> <span class="artcileColumn">${article.artcileColumn} </span>
				</span> <span class="articleSpanButton"><button id="editBut"
						type="button" class="btn blue articleNormal"
						onclick="edit('${article.id}')">修改</button>
					<button id="topBut" type="button" class="btn blue articleForm"
						onclick="top('${article.id}')">置顶</button>
					<button id="deleteBut" type="button" class="btn blue articleForm"
						onclick="delete('${article.id}')">删除</button> </span>
			</div>
		</c:forEach>
		<div id="add" class="articleLine">
			<span class="articleSpanContent">新增文章 </span> <span
				class="articleSpanButton"><button id="editBut" type="button"
					class="btn blue articleNormal" onclick="edit('add')">新增</button> </span>
		</div>
		<div class="pageBox">
			<input type="hidden" id="pageNo" value="${page.pageNo}" />
			<c:if test="${page.pageNo eq 1}">
				<span class="page firstP">首页</span>
				<span class="page beforeP">上一页</span>
			</c:if>
			<c:if test="${page.pageNo > 1}">
				<span class="page firstP clickable" onclick="query(1)">首页</span>
				<span class="page beforeP clickable"
					onclick="query(${page.pageNo-1})">上一页</span>
			</c:if>
			<c:if test="${page.totalPages<5}">
				<c:forEach begin="1" end="${page.totalPages}" varStatus="index">
					<span class="page numP clickable" id="${index.index}"
						onclick="query(${index.index})">${index.index}</span>
				</c:forEach>
			</c:if>
			<c:if test="${page.totalPages>5}">
				<c:if test="${page.pageNo<=3}">
					<c:forEach begin="1" end="5" varStatus="index">
						<span class="page numP clickable" id="${index.index}"
							onclick="query(${index.index})">${index.index}</span>
					</c:forEach>
				</c:if>
			</c:if>
			<span class="page countP">第${page.pageNo}/${page.totalPages}页（共${page.totalCount}条结果）</span>
			<c:if test="${page.totalPages>5}">
				<c:if test="${page.pageNo>=4&&page.pageNo<=page.totalPages-2}">
					<c:forEach begin="${page.pageNo-2}" end="${page.pageNo+2}"
						varStatus="index">
						<span class="page numP clickable" id="${index.index}"
							onclick="query(${index.index})">${index.index}</span>
					</c:forEach>
				</c:if>
			</c:if>
			<c:if test="${page.totalPages>5}">
				<c:if test="${page.pageNo>(page.totalPages-2)}">
					<c:forEach begin="${page.totalPages-4}" end="${page.totalPages}"
						varStatus="index">
						<span class="page numP clickable" id="${index.index}"
							onclick="query(${index.index})">${index.index}</span>
					</c:forEach>
				</c:if>
			</c:if>
			<c:if test="${page.pageNo eq page.totalPages}">
				<span class="page afterP">下一页</span>
				<span class="page lastP">尾页</span>
			</c:if>
			<c:if test="${page.pageNo < page.totalPages}">
				<span class="page afterP clickable"
					onclick="query(${page.pageNo+1})">下一页</span>
				<span class="page lastP clickable"
					onclick="query(${page.totalPages})">尾页</span>
			</c:if>
		</div>
	</div>
	<div class="articleContent">
		<span class="articleForm"><span>文章名：</span><input type="text"
			id="articleName" class="form-control placeholder-no-fix"
			onblur="check(this)" /></span> <span class="articleForm"><span>文章title：</span><input
			type="text" id="articleTitle" class="form-control placeholder-no-fix"
			onblur="check(this)" /></span> <span class="articleForm"><span>文章keyword：</span><input
			type="text" id="articleKeyword"
			class="form-control placeholder-no-fix" onblur="check(this)" /></span> <span
			class="articleForm"><span>文章description：</span><input
			type="text" id="articleInfo" class="form-control placeholder-no-fix"
			onblur="check(this)" /></span> <input type="hidden" id="id" /><span
			id="msg" class="articleForm"><span>文章内容：</span> <span
			id="summernote" class="uploadItem"></span></span> <span
			class="articleSpanButton"><button id="saveBut" type="button"
				class="btn blue articleNormal" onclick="save()">保存</button>
			<button id="cancelBut" type="button" class="btn blue articleForm"
				onclick="cancel()">取消</button>
			<button id="deleteBut" type="button" class="btn red articleForm"
				onclick="del()">删除</button> </span>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#summernote').summernote({
				height : 500,
				minHeight : null,
				maxHeight : null,
				lang: 'zh-CN',
				toolbar: [
					['style', ['bold', 'italic', 'underline', 'clear']],
					['fontsize', ['fontname', 'fontsize']],
					['color', ['color']],
					[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
					[ 'Insert', [ 'table' ] ] ],
				fontNames: ['宋体', '黑体', '楷体', '微软雅黑'],
				disableDragAndDrop: true
			});
		});
		
		function edit(id) {
			$(".articleList").hide("fast");
			$(".articleContent").show("fast");
			if (id == 'add') {
				$('#id').val("add");
				$('#articleName').val("");
				$('#articleTitle').val("");
				$('#articleKeyword').val("");
				$('#articleInfo').val("");
				$('#summernote').summernote('code', "");
				$('#articleColumn').val("");
			} else {
				var url = 'rest/article/getOne';
				$.getJSON(url, {
					'id' : id
				}, function(data) {
					$('#id').val(data.id);
					$('#articleName').val(data.articleName);
					$('#articleTitle').val(data.articleTitle);
					$('#articleKeyword').val(data.articleKeyword);
					$('#articleInfo').val(data.articleInfo);
					$('#summernote').summernote('code', data.articleContet);
					$('#articleColumn').val(data.articleColumn);
				});
			}
		}

		function cancel(id) {
			$(".articleList").show("fast");
			$(".articleContent").hide("fast");
		}

		function save() {
			var id = $('#id').val();
			if (check($('#articleName').get(0))) {
				if (check($('#articleTitle').get(0))) {
					if (check($('#articleKeyword').get(0))) {
						if (check($('#articleInfo').get(0))) {
							if (check($('#articleColumn').get(0))) {
								var url = 'rest/article/save';
								$.getJSON(url, 
										{
											'id' : $('#id').val(),
											'articleName' : $('#articleName').val(),
											'articleContent' : $('#summernote').summernote('code'),
											'articleTitle' : $('#articleTitle').val(),
											'articleKeyword' : $('#articleKeyword').val(),
											'articleInfo' : $('#articleInfo').val(),
											'articleColumn' : $('#articleColumn').val()
										},
										function(data) {
											$('#id').val(data.id);
											$('#articleName').val(data.articleName);
											$('#articleTitle').val(data.articleTitle);
											$('#articleKeyword').val(data.articleKeyword);
											$('#articleInfo').val(data.articleInfo);
											$('#summernote').summernote('code', data.articleContet);
											$('#articleColumn').val(data.articleColumn);
											$("#msg").css('display', 'block');
											$("#msg").css('color', data.msg0);
											$("#msg").html(data.msg);
								});
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
			} else {
				return false;
			}
		}

		function start(id) {
			var url = 'rest/article/start';
			$.getJSON(url, {
				'id' : $('#' + id + " input[name='ids']").val()
			}, function(data) {
				$('#' + id + "_name").val(data.articleName);
				$('#' + id + " .articleName").html(data.articleName);
				if (data.articleStatus == 0) {
					$('#' + id + " .articleName").append("（已停用）");
				}
				$('#' + id + "_title").val(data.articleTitle);
				$('#' + id + "_keyword").val(data.articleKeyword);
				$('#' + id + "_info").val(data.articleInfo);
				if (data.msg.indexOf("成功") > -1) {
					$('#' + id + " #stopBut").toggleClass('articleStatus');
					$('#' + id + " #startBut").toggleClass('articleStatus');
				}
				$('#' + id + " .articleNormal").show("fast");
				$('#' + id + " .articleForm").hide("fast");
				$('#' + id + " #msg").css('display', 'block');
				$('#' + id + " #msg").css('color', data.msg0);
				$('#' + id + " #msg").html(data.msg);
			});
		}

		function del() {
			var url = 'rest/article/stop';
			$.getJSON(url, {
				'id' : $('#' + id + " input[name='ids']").val()
			}, function(data) {
				$('#' + id + "_name").val(data.articleName);
				$('#' + id + " .articleName").html(data.articleName);
				if (data.articleStatus == 0) {
					$('#' + id + " .articleName").append("（已停用）");
				}
				$('#' + id + "_title").val(data.articleTitle);
				$('#' + id + "_keyword").val(data.articleKeyword);
				$('#' + id + "_info").val(data.articleInfo);
				if (data.msg.indexOf("成功") > -1) {
					$('#' + id + " #stopBut").toggleClass('articleStatus');
					$('#' + id + " #startBut").toggleClass('articleStatus');
				}
				$('#' + id + " .articleNormal").show("fast");
				$('#' + id + " .articleForm").hide("fast");
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
			var url = 'rest/article/sort';
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