package com.oa.common;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.oa.action.BaseAction;
import com.sun.org.apache.regexp.internal.recompile;

public class PageTag extends SimpleTagSupport {
	private int currPage;
	private int totalCount;
	private int totalPage;

	@Override
	public void doTag() throws JspException, IOException {
		PageContext context = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();

		UserInfo userInfo = (UserInfo) request
				.getAttribute(BaseAction.USER_INFO);
		setCurrPage(userInfo.getCurrPage());
		setTotalCount(userInfo.getTotalCount());
		setTotalPage(userInfo.getTotalPage());
		context.getOut().write(getHtml());
	}

	private String getHtml() {
		StringBuffer html = new StringBuffer();
		// html.append("<tr>");
		// html
		// .append("<td height='30'><table width='100%' border='0' cellspacing='0' cellpadding='0'>");
		// html.append("<tr>");
		// html.append("<td width='33%'>");
		// html.append("<div align='right'>");
		// html.append("<span class='STYLE22'>&nbsp;&nbsp;&nbsp;&nbsp;共有<strong>"
		// + userInfo.getTotalCount() + "</strong> 条记录，当前第<strong>"
		// + userInfo.getCurrPage() + "</strong> 页，共 <strong>"
		// + userInfo.getTotalPage() + "</strong> 页</span>");
		// html.append("</div>");
		// html.append("</td>");
		// html.append("</tr>");
		// html.append("</table>");
		// html.append("</td>");
		// html.append("</tr>");
		html
				.append("<table width='100%'><tr><td width='40%'><div align='left'><span class='STYLE22'>&nbsp;&nbsp;&nbsp;&nbsp;共有 <strong>"
						+ totalCount
						+ "</strong> 条记录，当前第 <strong> "
						+ currPage
						+ "</strong> 页，共 <strong>"
						+ totalPage
						+ "</strong> 页</span></div></td>"
						+ "<td width='60%'>"
						+ "<div align='right'><span class='STYLE22'>");

		if (currPage > 1) {
			html.append("<a href='javascript:ChangePage(1);'>首页</a>");
			html.append("&nbsp;&nbsp;&nbsp;");
			html.append("<a href='javascript:ChangePage(" + (currPage - 1)
					+ ")'>上一页</a>");
			html.append("&nbsp;&nbsp;&nbsp;");
		} else {
			html.append("首页");
			html.append("&nbsp;&nbsp;&nbsp;");
			html.append("上一页");
			html.append("&nbsp;&nbsp;&nbsp;");
		}
		if (currPage < totalPage) {
			html.append("<a href='javascript:ChangePage(" + (currPage + 1)
					+ ")'>下一页</a>");
			html.append("&nbsp;&nbsp;&nbsp;");
		} else {
			html.append("下一页");
			html.append("&nbsp;&nbsp;&nbsp;");
		}
		if (totalPage > 1 && currPage != totalPage) {
			html.append("<a href='javascript:ChangePage(" + totalPage
					+ ")'>尾页</a>");
			html.append("&nbsp;&nbsp;&nbsp;");
		} else {
			html.append("尾页");
			html.append("&nbsp;&nbsp;&nbsp;");
		}
		html.append("转到 ");
		html
				.append("<select name='currPage' onchange='javascript:ChangePage(this.value);'>");
		for (int i = 1; i <= totalPage; i++) {
			html.append("<option value='" + i + "'");
			if (currPage == i) {
				html.append("selected");
			}
			html.append(">");
			html.append("" + i + "");
			html.append("</option>");
		}
		html.append("</select> 页");

		html.append("</span></div></td></tr></table>");

		html.append("<script language='javascript'>");
		html.append("function ChangePage(page){");
		html.append("document.form.action = " + "document.form.action + "
				+ "'?userInfo.currPage='+page;");
		html.append("document.form.submit();");
		html.append("}");
		html.append("</script>");

		return html.toString();
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
