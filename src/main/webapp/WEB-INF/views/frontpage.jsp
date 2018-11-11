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
<link rel="alternate icon" type="image/png" href="/assets/i/favicon.png">
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

.article-div {
	background-color: RGBA(204, 204, 204, .3);
	border-radius: 40px;
}

.blog-main {
	padding: 20px 0 20px 0;
}

.blog-title {
	margin: 10px 0 20px 0;
	padding: 10px 10px 10px 0;
	background-color: RGBA(255, 255, 255, .2);
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

.blog-sidebar {
	background-color: RGBA(204, 204, 204, .3);
	border-radius: 20px;
}

.nodata {
	height: 32px;
	line-height: 32px;
	text-align: center;
	color: #999;
	font-size: 14px;
}

body:before {
	content: ' ';
	position: fixed;
	z-index: -1;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	/* background: url(/app/img/back.png) center 0 no-repeat; */
	background-color: #1570a675;
	background-size: cover;
}

header {
	background-color: #1570a6;
}

.is-click-title {
	cursor: pointer;
}

.is-hide-title {
	margin-top: 0px !important;
	margin-bottom: 0px !important;
}

.is-hide {
	display: none;
}

.is-hide-article {
	padding-top: 0px !important;
	padding-bottom: 0px !important;
}

</style>
</head>
<body>
	<header class="am-topbar">

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
		</div>
	</header>

	<div class="am-g am-g-fixed blog-g-fixed">
		<div class="am-u-md-8 article-div">

			<input type="hidden" id="columnId" value="${columnId}" />
			<div class="am-u-lg-12 nodata">向下加载更多</div>
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
		var isbool = true;
		$(function() {
			$
					.ajax({
						'type' : "GET",
						'url' : '/rest/front/article',
						'dataType' : 'json',
						'data' : {
							'pageSize' : 5,
							'column' : $('#columnId').val(),
							'pageNo' : 1
						},
						'beforeSend' : function() {
							$(".nodata").html('加载中……');
						},
						'success' : function(data) {
							if (data.result.length != 0) {
								$
										.each(
												data.result,
												function(i, n) {
													if (i != 0) {
														$("#columnId")
															.before(
																	'<article class="blog-main is-hide-article"><h3 class="am-article-title blog-title is-hide-title is-click-title">'
																			+ n.articleName
																			+ '</h3><div class="am-g blog-content is-hide"><div class="am-u-lg-12">'
																			+ n.articleContent
																			+ '</div></div></article><hr class="am-article-divider blog-hr">');
													} else {
														$("#columnId")
														.before(
																'<article class="blog-main"><h3 class="am-article-title blog-title">'
																		+ n.articleName
																		+ '</h3><div class="am-g blog-content"><div class="am-u-lg-12">'
																		+ n.articleContent
																		+ '</div></div></article><hr class="am-article-divider blog-hr">');
													}
												});
							}
							if (data.result.length < 5) {
								$(".nodata").html('没有更多文章了');
							}

							
							$(".is-hide-title").click(function () {
								$(this).toggleClass("is-hide-title");
								$(this).next().toggleClass("is-hide");
								$(this).parent().toggleClass("is-hide-article");
							});
						}
					});
			var winH = $(window).height();
			var i = 2;
			$(window)
					.scroll(
							function() {
								isbool = false;
								var pageH = $(document.body).height();
								var scrollT = $(window).scrollTop();
								var aa = (pageH - winH - scrollT) / winH;
								if (aa < 0.02 || $(".nodata").html() != '加载中……') {
									$
											.ajax({
												'type' : "GET",
												'url' : '/rest/front/article',
												'dataType' : 'json',
												'data' : {
													'pageSize' : 5,
													'column' : $('#columnId')
															.val(),
													'pageNo' : i
												},
												'beforeSend' : function() {
													$(".nodata").html('加载中……');
												},
												'success' : function(data) {
													if (data.result.length != 0) {
														$
																.each(
																		data.result,
																		function(
																				i,
																				n) {
																			$(
																					"#columnId")
																					.before(
																							'<article class="blog-main is-hide-article"><h3 class="am-article-title blog-title is-hide-title is-click-title">'
																									+ n.articleName
																									+ '</h3><div class="am-g blog-content is-hide"><div class="am-u-lg-7">'
																									+ n.articleContent
																									+ '</div></div></article><hr class="am-article-divider blog-hr">');
																		});
														i++;
														isbool = true;
													}
													if (data.result.length < 5) {
														$(".nodata").html(
																'没有更多文章了');
													}
													
													$(".is-hide-title").click(function () {
														$(this).toggleClass("is-hide-title");
														$(this).next().toggleClass("is-hide");
														$(this).parent().toggleClass("is-hide-article");
													});
												}
											});
								}
							});
		});
	</script>
	<script>
		var _hmt = _hmt || [];
		(function() {
  			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?140d1f49215c81203f9f22c0a2eb212a";
			var s = document.getElementsByTagName("script")[0]; 
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
	
</body>
</html>
