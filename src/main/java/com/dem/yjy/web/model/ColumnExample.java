package com.dem.yjy.web.model;

import java.util.ArrayList;
import java.util.List;

public class ColumnExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ColumnExample() {
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

		public Criteria andColumnNameIsNull() {
			addCriterion("`column_name` is null");
			return (Criteria) this;
		}

		public Criteria andColumnNameIsNotNull() {
			addCriterion("`column_name` is not null");
			return (Criteria) this;
		}

		public Criteria andColumnNameEqualTo(String value) {
			addCriterion("`column_name` =", value, "`columnName`");
			return (Criteria) this;
		}

		public Criteria andColumnNameNotEqualTo(String value) {
			addCriterion("`column_name` <>", value, "`columnName`");
			return (Criteria) this;
		}

		public Criteria andColumnNameGreaterThan(String value) {
			addCriterion("`column_name` >", value, "`columnName`");
			return (Criteria) this;
		}

		public Criteria andColumnNameGreaterThanOrEqualTo(String value) {
			addCriterion("`column_name` >=", value, "`columnName`");
			return (Criteria) this;
		}

		public Criteria andColumnNameLessThan(String value) {
			addCriterion("`column_name` <", value, "`columnName`");
			return (Criteria) this;
		}

		public Criteria andColumnNameLessThanOrEqualTo(String value) {
			addCriterion("`column_name` <=", value, "`columnName`");
			return (Criteria) this;
		}

		public Criteria andColumnNameLike(String value) {
			addCriterion("`column_name` like", value, "`columnName`");
			return (Criteria) this;
		}

		public Criteria andColumnNameNotLike(String value) {
			addCriterion("`column_name` not like", value, "`columnName`");
			return (Criteria) this;
		}

		public Criteria andColumnNameIn(List<String> values) {
			addCriterion("`column_name` in", values, "`columnName`");
			return (Criteria) this;
		}

		public Criteria andColumnNameNotIn(List<String> values) {
			addCriterion("`column_name` not in", values, "`columnName`");
			return (Criteria) this;
		}

		public Criteria andColumnNameBetween(String value1, String value2) {
			addCriterion("`column_name` between", value1, value2, "`columnName`");
			return (Criteria) this;
		}

		public Criteria andColumnNameNotBetween(String value1, String value2) {
			addCriterion("`column_name` not between", value1, value2, "`columnName`");
			return (Criteria) this;
		}

		public Criteria andColumnInfoIsNull() {
			addCriterion("column_info is null");
			return (Criteria) this;
		}

		public Criteria andColumnInfoIsNotNull() {
			addCriterion("column_info is not null");
			return (Criteria) this;
		}

		public Criteria andColumnInfoEqualTo(String value) {
			addCriterion("column_info =", value, "columnInfo");
			return (Criteria) this;
		}

		public Criteria andColumnInfoNotEqualTo(String value) {
			addCriterion("column_info <>", value, "columnInfo");
			return (Criteria) this;
		}

		public Criteria andColumnInfoGreaterThan(String value) {
			addCriterion("column_info >", value, "columnInfo");
			return (Criteria) this;
		}

		public Criteria andColumnInfoGreaterThanOrEqualTo(String value) {
			addCriterion("column_info >=", value, "columnInfo");
			return (Criteria) this;
		}

		public Criteria andColumnInfoLessThan(String value) {
			addCriterion("column_info <", value, "columnInfo");
			return (Criteria) this;
		}

		public Criteria andColumnInfoLessThanOrEqualTo(String value) {
			addCriterion("column_info <=", value, "columnInfo");
			return (Criteria) this;
		}

		public Criteria andColumnInfoLike(String value) {
			addCriterion("column_info like", value, "columnInfo");
			return (Criteria) this;
		}

		public Criteria andColumnInfoNotLike(String value) {
			addCriterion("column_info not like", value, "columnInfo");
			return (Criteria) this;
		}

		public Criteria andColumnInfoIn(List<String> values) {
			addCriterion("column_info in", values, "columnInfo");
			return (Criteria) this;
		}

		public Criteria andColumnInfoNotIn(List<String> values) {
			addCriterion("column_info not in", values, "columnInfo");
			return (Criteria) this;
		}

		public Criteria andColumnInfoBetween(String value1, String value2) {
			addCriterion("column_info between", value1, value2, "columnInfo");
			return (Criteria) this;
		}

		public Criteria andColumnInfoNotBetween(String value1, String value2) {
			addCriterion("column_info not between", value1, value2, "columnInfo");
			return (Criteria) this;
		}

		public Criteria andColumnTitleIsNull() {
			addCriterion("column_title is null");
			return (Criteria) this;
		}

		public Criteria andColumnTitleIsNotNull() {
			addCriterion("column_title is not null");
			return (Criteria) this;
		}

		public Criteria andColumnTitleEqualTo(String value) {
			addCriterion("column_title =", value, "columnTitle");
			return (Criteria) this;
		}

		public Criteria andColumnTitleNotEqualTo(String value) {
			addCriterion("column_title <>", value, "columnTitle");
			return (Criteria) this;
		}

		public Criteria andColumnTitleGreaterThan(String value) {
			addCriterion("column_title >", value, "columnTitle");
			return (Criteria) this;
		}

		public Criteria andColumnTitleGreaterThanOrEqualTo(String value) {
			addCriterion("column_title >=", value, "columnTitle");
			return (Criteria) this;
		}

		public Criteria andColumnTitleLessThan(String value) {
			addCriterion("column_title <", value, "columnTitle");
			return (Criteria) this;
		}

		public Criteria andColumnTitleLessThanOrEqualTo(String value) {
			addCriterion("column_title <=", value, "columnTitle");
			return (Criteria) this;
		}

		public Criteria andColumnTitleLike(String value) {
			addCriterion("column_title like", value, "columnTitle");
			return (Criteria) this;
		}

		public Criteria andColumnTitleNotLike(String value) {
			addCriterion("column_title not like", value, "columnTitle");
			return (Criteria) this;
		}

		public Criteria andColumnTitleIn(List<String> values) {
			addCriterion("column_title in", values, "columnTitle");
			return (Criteria) this;
		}

		public Criteria andColumnTitleNotIn(List<String> values) {
			addCriterion("column_title not in", values, "columnTitle");
			return (Criteria) this;
		}

		public Criteria andColumnTitleBetween(String value1, String value2) {
			addCriterion("column_title between", value1, value2, "columnTitle");
			return (Criteria) this;
		}

		public Criteria andColumnTitleNotBetween(String value1, String value2) {
			addCriterion("column_title not between", value1, value2, "columnTitle");
			return (Criteria) this;
		}

		public Criteria andColumnKeywordIsNull() {
			addCriterion("column_keyword is null");
			return (Criteria) this;
		}

		public Criteria andColumnKeywordIsNotNull() {
			addCriterion("column_keyword is not null");
			return (Criteria) this;
		}

		public Criteria andColumnKeywordEqualTo(String value) {
			addCriterion("column_keyword =", value, "columnKeyword");
			return (Criteria) this;
		}

		public Criteria andColumnKeywordNotEqualTo(String value) {
			addCriterion("column_keyword <>", value, "columnKeyword");
			return (Criteria) this;
		}

		public Criteria andColumnKeywordGreaterThan(String value) {
			addCriterion("column_keyword >", value, "columnKeyword");
			return (Criteria) this;
		}

		public Criteria andColumnKeywordGreaterThanOrEqualTo(String value) {
			addCriterion("column_keyword >=", value, "columnKeyword");
			return (Criteria) this;
		}

		public Criteria andColumnKeywordLessThan(String value) {
			addCriterion("column_keyword <", value, "columnKeyword");
			return (Criteria) this;
		}

		public Criteria andColumnKeywordLessThanOrEqualTo(String value) {
			addCriterion("column_keyword <=", value, "columnKeyword");
			return (Criteria) this;
		}

		public Criteria andColumnKeywordLike(String value) {
			addCriterion("column_keyword like", value, "columnKeyword");
			return (Criteria) this;
		}

		public Criteria andColumnKeywordNotLike(String value) {
			addCriterion("column_keyword not like", value, "columnKeyword");
			return (Criteria) this;
		}

		public Criteria andColumnKeywordIn(List<String> values) {
			addCriterion("column_keyword in", values, "columnKeyword");
			return (Criteria) this;
		}

		public Criteria andColumnKeywordNotIn(List<String> values) {
			addCriterion("column_keyword not in", values, "columnKeyword");
			return (Criteria) this;
		}

		public Criteria andColumnKeywordBetween(String value1, String value2) {
			addCriterion("column_keyword between", value1, value2, "columnKeyword");
			return (Criteria) this;
		}

		public Criteria andColumnKeywordNotBetween(String value1, String value2) {
			addCriterion("column_keyword not between", value1, value2, "columnKeyword");
			return (Criteria) this;
		}

		public Criteria andColumnSortIsNull() {
			addCriterion("column_sort is null");
			return (Criteria) this;
		}

		public Criteria andColumnSortIsNotNull() {
			addCriterion("column_sort is not null");
			return (Criteria) this;
		}

		public Criteria andColumnSortEqualTo(Integer value) {
			addCriterion("column_sort =", value, "columnSort");
			return (Criteria) this;
		}

		public Criteria andColumnSortNotEqualTo(Integer value) {
			addCriterion("column_sort <>", value, "columnSort");
			return (Criteria) this;
		}

		public Criteria andColumnSortGreaterThan(Integer value) {
			addCriterion("column_sort >", value, "columnSort");
			return (Criteria) this;
		}

		public Criteria andColumnSortGreaterThanOrEqualTo(Integer value) {
			addCriterion("column_sort >=", value, "columnSort");
			return (Criteria) this;
		}

		public Criteria andColumnSortLessThan(Integer value) {
			addCriterion("column_sort <", value, "columnSort");
			return (Criteria) this;
		}

		public Criteria andColumnSortLessThanOrEqualTo(Integer value) {
			addCriterion("column_sort <=", value, "columnSort");
			return (Criteria) this;
		}

		public Criteria andColumnSortIn(List<Integer> values) {
			addCriterion("column_sort in", values, "columnSort");
			return (Criteria) this;
		}

		public Criteria andColumnSortNotIn(List<Integer> values) {
			addCriterion("column_sort not in", values, "columnSort");
			return (Criteria) this;
		}

		public Criteria andColumnSortBetween(Integer value1, Integer value2) {
			addCriterion("column_sort between", value1, value2, "columnSort");
			return (Criteria) this;
		}

        public Criteria andColumnSortNotBetween(Integer value1, Integer value2) {
            addCriterion("column_sort not between", value1, value2, "columnSort");
            return (Criteria) this;
        }

        public Criteria andColumnStatusIsNull() {
            addCriterion("column_status is null");
            return (Criteria) this;
        }

        public Criteria andColumnStatusIsNotNull() {
            addCriterion("column_status is not null");
            return (Criteria) this;
        }

        public Criteria andColumnStatusEqualTo(Integer value) {
            addCriterion("column_status =", value, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusNotEqualTo(Integer value) {
            addCriterion("column_status <>", value, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusGreaterThan(Integer value) {
            addCriterion("column_status >", value, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("column_status >=", value, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusLessThan(Integer value) {
            addCriterion("column_status <", value, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusLessThanOrEqualTo(Integer value) {
            addCriterion("column_status <=", value, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusIn(List<Integer> values) {
            addCriterion("column_status in", values, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusNotIn(List<Integer> values) {
            addCriterion("column_status not in", values, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusBetween(Integer value1, Integer value2) {
            addCriterion("column_status between", value1, value2, "columnStatus");
            return (Criteria) this;
        }

        public Criteria andColumnStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("column_status not between", value1, value2, "columnStatus");
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