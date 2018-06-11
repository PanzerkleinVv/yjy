<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head lang="zh">
<meta charset="UTF-8">
<title>${preferences["title"]}</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta name="keywords" content='${preferences["keywords"]}'>
<meta name="description" content='${preferences["description"]}'>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png"
	href="/assets/i/favicon.png">
<link rel="stylesheet" href="/assets/css/amazeui.min.css" />
<style>
@media only screen and (min-width: 1200px) {
	.blog-g-fixed {
		max-width: 1200px;
	}
}

@media only screen and (min-width: 641px) {
	.blog-sidebar {
		font-size: 1.4rem;
	}
}

.blog-main {
	padding: 20px 0;
}

.blog-title {
	margin: 10px 0 20px 0;
}

.blog-meta {
	font-size: 14px;
	margin: 10px 0 20px 0;
	color: #222;
}

.blog-meta a {
	color: #27ae60;
}

.blog-pagination a {
	font-size: 1.4rem;
}

.blog-team li {
	padding: 4px;
}

.blog-team img {
	margin-bottom: 0;
}

.blog-content img, .blog-team img {
	max-width: 100%;
	height: auto;
}

.blog-footer {
	padding: 10px 0;
	text-align: center;
}

.nodata {
	height: 32px;
	line-height: 32px;
	text-align: center;
	color: #999;
	font-size: 14px;
}
</style>
</head>
<body>
	<header class="am-topbar">
		<h1 class="am-topbar-brand">
			<a href="#">${preferences["name"]}</a>
		</h1>

		<button
			class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
			data-am-collapse="{target: '#doc-topbar-collapse'}">
			<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
		</button>

		<div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
			<ul class="am-nav am-nav-pills am-topbar-nav">
				<li
					<c:if test='${columnId == null || columnId eq ""}'>class="am-active"</c:if>><a
					href="/rest/front/frontpage?columnId=">首页</a></li>
				<c:forEach var='column' items='${columns}'>
					<li <c:if test='${columnId eq column.id}'>class="am-active"</c:if>><a
						href="/rest/front/frontpage?columnId=${column.id}">${column.columnName}</a></li>
				</c:forEach>

			</ul>
			<!--
			<form
				class="am-topbar-form am-topbar-left am-form-inline am-topbar-right"
				role="search">
				<div class="am-form-group">
					<input type="text" class="am-form-field am-input-sm"
						placeholder="搜索文章">
				</div>
				<button type="submit" class="am-btn am-btn-default am-btn-sm">搜索</button>
			</form>
			-->
		</div>
	</header>

	<div class="am-g am-g-fixed blog-g-fixed">
		<div class="am-u-md-8 article-div">

			<input type="hidden" id="columnId" value="${columnId}" />
			<div class="am-u-lg-7 nodata">向下加载更多</div>
		</div>

		

		<div class="am-u-md-4 blog-sidebar">
			<div class="am-panel-group">
				<section class="am-panel am-panel-default">
					<div class="am-panel-hd">关于我</div>
					<div class="am-panel-bd">
						<p>${preferences["aboutme"]}</p>
					</div>
				</section>
			</div>
		</div>

	</div>

	<footer class="blog-footer">
		<p>
			${preferences["name"]}<br /> <small>© Copyright
				PanzerkleinVv.</small>
		</p>
	</footer>

	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="/assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="/assets/plugins/jquery/jquery-1.11.1.min.js"></script>
	<!--<![endif]-->
	<script src="/assets/js/amazeui.min.js"></script>
	<script lang="javascript">
		var isbool=true;
		$(function() {
			$.ajax({'type':"GET",
				'url':'/rest/front/article',
				'dataType':'json', 'data':{
					'pageSize' : 5,
					'column' : $('#columnId').val(),
					'pageNo' : 1},
				'beforeSend': function() {
					$(".nodata").html('加载中……');
		         },
				'success':function(data) {
					if (data.result.length != 0) {
						$.each(data.result, function(i, n) {
							$("#columnId").before('<article class="blog-main"><h3 class="am-article-title blog-title">'
									+ n.articleName
									+ '</h3><div class="am-g blog-content"><div class="am-u-lg-7">'
									+ n.articleContent
									+ '</div></div></article><hr class="am-article-divider blog-hr">');
						});
					}
					if (data.result.length < 5) {
						$(".nodata").html('没有更多文章了');
					}
		}});
			var winH = $(window).height();
			var i = 2;
			$(window)
					.scroll(
							function() {
								isbool=false;
								var pageH = $(document.body).height();
								var scrollT = $(window).scrollTop();
								var aa = (pageH - winH - scrollT) / winH;
								if (aa < 0.02) {
									$.ajax({'type':"GET",
											'url':'/rest/front/article',
											'dataType':'json', 'data':{
												'pageSize' : 5,
												'column' : $('#columnId').val(),
												'pageNo' : i},
											'beforeSend': function() {
												$(".nodata").html('加载中……');
									         },
											'success':function(data) {
												if (data.result.length != 0) {
													$.each(data.result, function(i, n) {
														$("#columnId").before('<article class="blog-main"><h3 class="am-article-title blog-title">'
																+ n.articleName
																+ '</h3><div class="am-g blog-content"><div class="am-u-lg-7">'
																+ n.articleContent
																+ '</div></div></article><hr class="am-article-divider blog-hr">');
													});
													i++;
													isbool=true;
												}
												if (data.result.length < 5) {
													$(".nodata").html('没有更多文章了');
												}
									}});
								}
							});
		});
	</script>

</body>
</html>
