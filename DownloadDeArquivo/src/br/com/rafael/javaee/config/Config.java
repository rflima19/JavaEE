package br.com.rafael.javaee.config;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;

@FacesConfig(version = Version.JSF_2_3)
@ApplicationScoped
public class Config implements Serializable {
}
