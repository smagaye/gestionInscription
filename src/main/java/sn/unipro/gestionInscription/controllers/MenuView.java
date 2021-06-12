package sn.unipro.gestionInscription.controllers;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean(name = "menuView")
@SessionScoped
public class MenuView implements Serializable {

	@PostConstruct
	public void init() {
		model = new DefaultMenuModel();
        //First submenu
        DefaultSubMenu firstSubmenu = DefaultSubMenu.builder()
                .label("Options")
                .build();

        DefaultMenuItem item = DefaultMenuItem.builder()
                .value("Save (Non-Ajax)")
                .icon("pi pi-save")
                .ajax(false)
                .command("#{menuView.save}")
                .update("messages")
                .build();
        firstSubmenu.getElements().add(item);
	}

	private MenuModel model;

	public void listeComptes() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("../admin/home.xhtml");
	}

}