package com.dem.yjy.web.model;

public class Article {
	private String id;

	private String articleName;

	private String articleContent;

	private String articleTitle;

	private String articleKeyword;

    private String articleInfo;

    private Integer articleSort;

    private Integer articleStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName == null ? null : articleName.trim();
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent == null ? null : articleContent.trim();
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle == null ? null : articleTitle.trim();
	}

	public String getArticleKeyword() {
		return articleKeyword;
	}

	public void setArticleKeyword(String articleKeyword) {
		this.articleKeyword = articleKeyword == null ? null : articleKeyword.trim();
	}

    public String getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(String articleInfo) {
        this.articleInfo = articleInfo == null ? null : articleInfo.trim();
    }

    public Integer getArticleSort() {
        return articleSort;
    }

    public void setArticleSort(Integer articleSort) {
        this.articleSort = articleSort;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }
}