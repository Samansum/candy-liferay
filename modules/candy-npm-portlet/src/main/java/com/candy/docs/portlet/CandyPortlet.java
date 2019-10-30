package com.candy.docs.portlet;

import com.candy.docs.constants.CandyPortletKeys;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import java.io.IOException;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author candy
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Candy Vue.js Portlet",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/html/view.jsp",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
		"javax.portlet.name=" + CandyPortletKeys.Candy,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CandyPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		renderRequest.setAttribute(
			"mainRequire",
				_npmResolver.resolveModuleName("candy-npm-portlet") + "/js/main.es as main");

		super.doView(renderRequest, renderResponse);
	}

	@Reference
	private NPMResolver _npmResolver;

}