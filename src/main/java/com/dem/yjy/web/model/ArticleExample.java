package com.dem.yjy.web.model;

import java.util.ArrayList;
import java.util.List;

public class ArticleExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ArticleExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(String value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(String value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(String value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(String value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLike(String value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotLike(String value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<String> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<String> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(String value1, String value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(String value1, String value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andArticleNameIsNull() {
			addCriterion("article_name is null");
			return (Criteria) this;
		}

		public Criteria andArticleNameIsNotNull() {
			addCriterion("article_name is not null");
			return (Criteria) this;
		}

		public Criteria andArticleNameEqualTo(String value) {
			addCriterion("article_name =", value, "articleName");
			return (Criteria) this;
		}

		public Criteria andArticleNameNotEqualTo(String value) {
			addCriterion("article_name <>", value, "articleName");
			return (Criteria) this;
		}

		public Criteria andArticleNameGreaterThan(String value) {
			addCriterion("article_name >", value, "articleName");
			return (Criteria) this;
		}

		public Criteria andArticleNameGreaterThanOrEqualTo(String value) {
			addCriterion("article_name >=", value, "articleName");
			return (Criteria) this;
		}

		public Criteria andArticleNameLessThan(String value) {
			addCriterion("article_name <", value, "articleName");
			return (Criteria) this;
		}

		public Criteria andArticleNameLessThanOrEqualTo(String value) {
			addCriterion("article_name <=", value, "articleName");
			return (Criteria) this;
		}

		public Criteria andArticleNameLike(String value) {
			addCriterion("article_name like", value, "articleName");
			return (Criteria) this;
		}

		public Criteria andArticleNameNotLike(String value) {
			addCriterion("article_name not like", value, "articleName");
			return (Criteria) this;
		}

		public Criteria andArticleNameIn(List<String> values) {
			addCriterion("article_name in", values, "articleName");
			return (Criteria) this;
		}

		public Criteria andArticleNameNotIn(List<String> values) {
			addCriterion("article_name not in", values, "articleName");
			return (Criteria) this;
		}

		public Criteria andArticleNameBetween(String value1, String value2) {
			addCriterion("article_name between", value1, value2, "articleName");
			return (Criteria) this;
		}

		public Criteria andArticleNameNotBetween(String value1, String value2) {
			addCriterion("article_name not between", value1, value2, "articleName");
			return (Criteria) this;
		}

        public Criteria andArtcileColumnIsNull() {
            addCriterion("artcile_column is null");
            return (Criteria) this;
        }

        public Criteria andArtcileColumnIsNotNull() {
            addCriterion("artcile_column is not null");
            return (Criteria) this;
        }

        public Criteria andArtcileColumnEqualTo(String value) {
            addCriterion("artcile_column =", value, "artcileColumn");
            return (Criteria) this;
        }

        public Criteria andArtcileColumnNotEqualTo(String value) {
            addCriterion("artcile_column <>", value, "artcileColumn");
            return (Criteria) this;
        }

        public Criteria andArtcileColumnGreaterThan(String value) {
            addCriterion("artcile_column >", value, "artcileColumn");
            return (Criteria) this;
        }

        public Criteria andArtcileColumnGreaterThanOrEqualTo(String value) {
            addCriterion("artcile_column >=", value, "artcileColumn");
            return (Criteria) this;
        }

        public Criteria andArtcileColumnLessThan(String value) {
            addCriterion("artcile_column <", value, "artcileColumn");
            return (Criteria) this;
        }

        public Criteria andArtcileColumnLessThanOrEqualTo(String value) {
            addCriterion("artcile_column <=", value, "artcileColumn");
            return (Criteria) this;
        }

        public Criteria andArtcileColumnLike(String value) {
            addCriterion("artcile_column like", value, "artcileColumn");
            return (Criteria) this;
        }

        public Criteria andArtcileColumnNotLike(String value) {
            addCriterion("artcile_column not like", value, "artcileColumn");
            return (Criteria) this;
        }

        public Criteria andArtcileColumnIn(List<String> values) {
            addCriterion("artcile_column in", values, "artcileColumn");
            return (Criteria) this;
        }

        public Criteria andArtcileColumnNotIn(List<String> values) {
            addCriterion("artcile_column not in", values, "artcileColumn");
            return (Criteria) this;
        }

        public Criteria andArtcileColumnBetween(String value1, String value2) {
            addCriterion("artcile_column between", value1, value2, "artcileColumn");
            return (Criteria) this;
        }

        public Criteria andArtcileColumnNotBetween(String value1, String value2) {
            addCriterion("artcile_column not between", value1, value2, "artcileColumn");
            return (Criteria) this;
        }

        public Criteria andArticleContentIsNull() {
            addCriterion("article_content is null");
            return (Criteria) this;
        }

		public Criteria andArticleContentIsNotNull() {
			addCriterion("article_content is not null");
			return (Criteria) this;
		}

		public Criteria andArticleContentEqualTo(String value) {
			addCriterion("article_content =", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentNotEqualTo(String value) {
			addCriterion("article_content <>", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentGreaterThan(String value) {
			addCriterion("article_content >", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentGreaterThanOrEqualTo(String value) {
			addCriterion("article_content >=", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentLessThan(String value) {
			addCriterion("article_content <", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentLessThanOrEqualTo(String value) {
			addCriterion("article_content <=", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentLike(String value) {
			addCriterion("article_content like", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentNotLike(String value) {
			addCriterion("article_content not like", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentIn(List<String> values) {
			addCriterion("article_content in", values, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentNotIn(List<String> values) {
			addCriterion("article_content not in", values, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentBetween(String value1, String value2) {
			addCriterion("article_content between", value1, value2, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentNotBetween(String value1, String value2) {
			addCriterion("article_content not between", value1, value2, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleTitleIsNull() {
			addCriterion("article_title is null");
			return (Criteria) this;
		}

		public Criteria andArticleTitleIsNotNull() {
			addCriterion("article_title is not null");
			return (Criteria) this;
		}

		public Criteria andArticleTitleEqualTo(String value) {
			addCriterion("article_title =", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleNotEqualTo(String value) {
			addCriterion("article_title <>", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleGreaterThan(String value) {
			addCriterion("article_title >", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
			addCriterion("article_title >=", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleLessThan(String value) {
			addCriterion("article_title <", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleLessThanOrEqualTo(String value) {
			addCriterion("article_title <=", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleLike(String value) {
			addCriterion("article_title like", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleNotLike(String value) {
			addCriterion("article_title not like", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleIn(List<String> values) {
			addCriterion("article_title in", values, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleNotIn(List<String> values) {
			addCriterion("article_title not in", values, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleBetween(String value1, String value2) {
			addCriterion("article_title between", value1, value2, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleNotBetween(String value1, String value2) {
			addCriterion("article_title not between", value1, value2, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleKeywordIsNull() {
			addCriterion("article_keyword is null");
			return (Criteria) this;
		}

		public Criteria andArticleKeywordIsNotNull() {
			addCriterion("article_keyword is not null");
			return (Criteria) this;
		}

		public Criteria andArticleKeywordEqualTo(String value) {
			addCriterion("article_keyword =", value, "articleKeyword");
			return (Criteria) this;
		}

		public Criteria andArticleKeywordNotEqualTo(String value) {
			addCriterion("article_keyword <>", value, "articleKeyword");
			return (Criteria) this;
		}

		public Criteria andArticleKeywordGreaterThan(String value) {
			addCriterion("article_keyword >", value, "articleKeyword");
			return (Criteria) this;
		}

		public Criteria andArticleKeywordGreaterThanOrEqualTo(String value) {
			addCriterion("article_keyword >=", value, "articleKeyword");
			return (Criteria) this;
		}

		public Criteria andArticleKeywordLessThan(String value) {
			addCriterion("article_keyword <", value, "articleKeyword");
			return (Criteria) this;
		}

		public Criteria andArticleKeywordLessThanOrEqualTo(String value) {
			addCriterion("article_keyword <=", value, "articleKeyword");
			return (Criteria) this;
		}

		public Criteria andArticleKeywordLike(String value) {
			addCriterion("article_keyword like", value, "articleKeyword");
			return (Criteria) this;
		}

		public Criteria andArticleKeywordNotLike(String value) {
			addCriterion("article_keyword not like", value, "articleKeyword");
			return (Criteria) this;
		}

		public Criteria andArticleKeywordIn(List<String> values) {
			addCriterion("article_keyword in", values, "articleKeyword");
			return (Criteria) this;
		}

		public Criteria andArticleKeywordNotIn(List<String> values) {
			addCriterion("article_keyword not in", values, "articleKeyword");
			return (Criteria) this;
		}

		public Criteria andArticleKeywordBetween(String value1, String value2) {
			addCriterion("article_keyword between", value1, value2, "articleKeyword");
			return (Criteria) this;
		}

		public Criteria andArticleKeywordNotBetween(String value1, String value2) {
			addCriterion("article_keyword not between", value1, value2, "articleKeyword");
			return (Criteria) this;
		}

        public Criteria andArticleInfoIsNull() {
            addCriterion("article_info is null");
            return (Criteria) this;
        }

        public Criteria andArticleInfoIsNotNull() {
            addCriterion("article_info is not null");
            return (Criteria) this;
        }

        public Criteria andArticleInfoEqualTo(String value) {
            addCriterion("article_info =", value, "articleInfo");
            return (Criteria) this;
        }

        public Criteria andArticleInfoNotEqualTo(String value) {
            addCriterion("article_info <>", value, "articleInfo");
            return (Criteria) this;
        }

        public Criteria andArticleInfoGreaterThan(String value) {
            addCriterion("article_info >", value, "articleInfo");
            return (Criteria) this;
        }

        public Criteria andArticleInfoGreaterThanOrEqualTo(String value) {
            addCriterion("article_info >=", value, "articleInfo");
            return (Criteria) this;
        }

        public Criteria andArticleInfoLessThan(String value) {
            addCriterion("article_info <", value, "articleInfo");
            return (Criteria) this;
        }

        public Criteria andArticleInfoLessThanOrEqualTo(String value) {
            addCriterion("article_info <=", value, "articleInfo");
            return (Criteria) this;
        }

        public Criteria andArticleInfoLike(String value) {
            addCriterion("article_info like", value, "articleInfo");
            return (Criteria) this;
        }

        public Criteria andArticleInfoNotLike(String value) {
            addCriterion("article_info not like", value, "articleInfo");
            return (Criteria) this;
        }

        public Criteria andArticleInfoIn(List<String> values) {
            addCriterion("article_info in", values, "articleInfo");
            return (Criteria) this;
        }

        public Criteria andArticleInfoNotIn(List<String> values) {
            addCriterion("article_info not in", values, "articleInfo");
            return (Criteria) this;
        }

        public Criteria andArticleInfoBetween(String value1, String value2) {
            addCriterion("article_info between", value1, value2, "articleInfo");
            return (Criteria) this;
        }

        public Criteria andArticleInfoNotBetween(String value1, String value2) {
            addCriterion("article_info not between", value1, value2, "articleInfo");
            return (Criteria) this;
        }

        public Criteria andArticleSortIsNull() {
            addCriterion("article_sort is null");
            return (Criteria) this;
        }

		public Criteria andArticleSortIsNotNull() {
			addCriterion("article_sort is not null");
			return (Criteria) this;
		}

		public Criteria andArticleSortEqualTo(Integer value) {
			addCriterion("article_sort =", value, "articleSort");
			return (Criteria) this;
		}

		public Criteria andArticleSortNotEqualTo(Integer value) {
			addCriterion("article_sort <>", value, "articleSort");
			return (Criteria) this;
		}

		public Criteria andArticleSortGreaterThan(Integer value) {
			addCriterion("article_sort >", value, "articleSort");
			return (Criteria) this;
		}

		public Criteria andArticleSortGreaterThanOrEqualTo(Integer value) {
			addCriterion("article_sort >=", value, "articleSort");
			return (Criteria) this;
		}

		public Criteria andArticleSortLessThan(Integer value) {
			addCriterion("article_sort <", value, "articleSort");
			return (Criteria) this;
		}

		public Criteria andArticleSortLessThanOrEqualTo(Integer value) {
			addCriterion("article_sort <=", value, "articleSort");
			return (Criteria) this;
		}

		public Criteria andArticleSortIn(List<Integer> values) {
			addCriterion("article_sort in", values, "articleSort");
			return (Criteria) this;
		}

		public Criteria andArticleSortNotIn(List<Integer> values) {
			addCriterion("article_sort not in", values, "articleSort");
			return (Criteria) this;
		}

		public Criteria andArticleSortBetween(Integer value1, Integer value2) {
			addCriterion("article_sort between", value1, value2, "articleSort");
			return (Criteria) this;
		}

        public Criteria andArticleSortNotBetween(Integer value1, Integer value2) {
            addCriterion("article_sort not between", value1, value2, "articleSort");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIsNull() {
            addCriterion("article_status is null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIsNotNull() {
            addCriterion("article_status is not null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusEqualTo(Integer value) {
            addCriterion("article_status =", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotEqualTo(Integer value) {
            addCriterion("article_status <>", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThan(Integer value) {
            addCriterion("article_status >", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_status >=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThan(Integer value) {
            addCriterion("article_status <", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("article_status <=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIn(List<Integer> values) {
            addCriterion("article_status in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotIn(List<Integer> values) {
            addCriterion("article_status not in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusBetween(Integer value1, Integer value2) {
            addCriterion("article_status between", value1, value2, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("article_status not between", value1, value2, "articleStatus");
            return (Criteria) this;
        }
    }

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}