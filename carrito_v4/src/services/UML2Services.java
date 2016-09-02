package services;

import java.util.List;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;

public class UML2Services {
	public boolean hasStereotype(Class clazz, String stereotypeName) {
		List<Stereotype> stereotypes = clazz.getAppliedStereotypes();
		for (Stereotype stereotype : stereotypes) {
			if (stereotype.getName().equals(stereotypeName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasStereotype(Package package1, String stereotypeName) {
		List<Stereotype> stereotypes = package1.getAppliedStereotypes();
		for (Stereotype stereotype : stereotypes) {
			if (stereotype.getName().equals(stereotypeName)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasStereotype(Element element, String stereotypeName) {
		List<Stereotype> stereotypes = element.getAppliedStereotypes();
		for (Stereotype stereotype : stereotypes) {
			if (stereotype.getName().equals(stereotypeName)) {
				return true;
			}
		}
		return false;
	}
	
	public String classFileName(String folderPath, Class clazz, String extension) {
		return folderPath.concat(clazz.getName().concat(extension));
	}

	public String getJavaType(String type) {
		String returnType = "";
		switch (type) {
		case "char":
		case "varchar":
		case "text":
			returnType = "String";
			break;

		case "int":
			returnType = "Integer";
			break;
		case "time":
		case "date":
		case "datetime":
			returnType = "BigDecimal";
			break;
		case "float":
			returnType = "Float";
			break;
			
		default:
			break;
		}

		return returnType;
	}

}
