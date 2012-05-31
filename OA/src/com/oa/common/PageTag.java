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
		// html.append("<span class='STYLE22'>&nbsp;&nbsp;&nbsp;&nbsp;����<strong>"
		// + userInfo.getTotalCount() + "</strong> ����¼����ǰ��<strong>"
		// + userInfo.getCurrPage() + "</strong> ҳ���� <strong>"
		// + userInfo.getTotalPage() + "</strong> ҳ</span>");
		// html.append("</div>");
		// html.append("</td>");
		// html.append("</tr>");
		// html.append("</table>");
		// html.append("</td>");
		// html.append("</tr>");
		html
				.append("<table width='100%'><tr><td width='40%'><div align='left'><span class='STYLE22'>&nbsp;&nbsp;&nbsp;&nbsp;���� <strong>"
						+ totalCount
						+ "</strong> ����¼����ǰ�� <strong> "
						+ currPage
						+ "</strong> ҳ���� <strong>"
						+ totalPage
						+ "</strong> ҳ</span></div></td>"
						+ "<td width='60%'>"
						+ "<div align='right'><span class='STYLE22'>");

		if (currPage > 1) {
			html.append("<a href='javascript:ChangePage(1);'>��ҳ</a>");
			html.append("&nbsp;&nbsp;&nbsp;");
			html.append("<a href='javascript:ChangePage(" + (currPage - 1)
					+ ")'>��һҳ</a>");
			html.append("&nbsp;&nbsp;&nbsp;");
		} else {
			html.append("��ҳ");
			html.append("&nbsp;&nbsp;&nbsp;");
			html.append("��һҳ");
			html.append("&nbsp;&nbsp;&nbsp;");
		}
		if (currPage < totalPage) {
			html.append("<a href='javascript:ChangePage(" + (currPage + 1)
					+ ")'>��һҳ</a>");
			html.append("&nbsp;&nbsp;&nbsp;");
		} else {
			html.append("��һҳ");
			html.append("&nbsp;&nbsp;&nbsp;");
		}
		if (totalPage > 1 && currPage != totalPage) {
			html.append("<a href='javascript:ChangePage(" + totalPage
					+ ")'>βҳ</a>");
			html.append("&nbsp;&nbsp;&nbsp;");
		} else {
			html.append("βҳ");
			html.append("&nbsp;&nbsp;&nbsp;");
		}
		html.append("ת�� ");
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
		html.append("</select> ҳ");

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
