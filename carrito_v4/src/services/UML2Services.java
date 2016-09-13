package services;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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

	public String classFileName(String folderPath, Class clazz, String nameExtension, String extension) {
		String className = clazz.getName().concat(nameExtension);
		return folderPath.concat(className.concat(extension));
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

	public String getSqliteType(String type) {
		String returnType = "";
		switch (type) {
		case "char":
		case "varchar":
		case "text":
			returnType = "text";
			break;

		case "int":
			returnType = "integer";
			break;
		case "time":
		case "date":
		case "datetime":
			returnType = "numeric";
			break;
		case "float":
			returnType = "real";
			break;

		default:
			break;
		}

		return returnType;
	}

	
		
	public String getSqliteProperties(String dataType, Boolean notNull, Integer size, 
			Boolean unique, String defaultValue, String checkCondition) {
		String result = "";
		
		result = result + dataType;
		
		
		if(size > 0)
			result = result+ "("+ String.valueOf(size)+")"+" ";
		
		if(notNull)
			result = result+"NOT NULL"+" ";
		
		if(unique)
			result = result+"UNIQUE"+" ";
		
		if(defaultValue != null)
		result = result + "DEFAULT "+defaultValue+" ";
		
		if(checkCondition != null)
			result = result+"CHECK ("+checkCondition+")";
		
		return result;
	}
		
	public String getCursorDescription(String javaDataType, Integer count){
		String result = "cursor.getString("+count+")";
		if(javaDataType.equals("Integer"))
			result = "Integer.parseInt("+result+")";
		
		if(javaDataType.equals("Float"))
			result = "Float.parseFloat("+result+")";
		
		if(javaDataType.equals("BigDecimal"))
			result = "new BigDecimal("+result+")";
		
		return result;
	}
}
