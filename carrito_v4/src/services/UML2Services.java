package services;

import java.util.List;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.internal.impl.EnumerationLiteralImpl;

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

	/*
	 * Esta funcion recorre los estereotipos de las clases de un paquete. Si un
	 * paquete contiene clases con el estereotipo deseado, devuelve TRUE, que
	 * ese paquete contiene ese estereotipo
	 */
	public boolean hasStereotype(Package packageT, String stereotypeName) {
		List<Stereotype> stereotypes = packageT.getAppliedStereotypes();

		for (Stereotype stereotype : stereotypes) {
			if (stereotype.getName().equals(stereotypeName)) {
				return true;
			}
		}
		return false;
	}

	public boolean isPackageHasThisClassStereotype(Package packageT, String stereotypeName) {
		List<Element> elements = packageT.getOwnedElements();

		for (Element element : elements) {
			if (hasStereotype(element, stereotypeName))
				return true;
		}
		return false;
	}

	/*Esta funcion es una bandera, que nos indica si dentro del paquete, existe una clase de un estereotipo especifico, 
	con una propiedad con un valor determinado. 
	Utilizado para ver si existe por lo menos un tipo de elemento.*/
	public boolean isPackageHasThisPropertyStereotype(Package packageT, String stereotypeName, String propertyName,
			String propertyValue) {
		List<Element> classes = packageT.getOwnedElements();

		for (Element classx : classes) {
			try {
				Class classex = (Class) classx;
				List<Stereotype> stereotypes = classex.getAppliedStereotypes();
				for (Stereotype stereotype : stereotypes) {
					if (stereotype.getName().equals(stereotypeName)) {
						Object object = classex.getValue(stereotype, propertyName);
						if (((EnumerationLiteralImpl) object).getName().equals(propertyValue)) {
							return true;
						}
					}
				}
			} catch (ClassCastException e) {
				// TODO: handle exception
				// Puede dar un error de casteo si es que viene un elemento el cual no pueda transformarse a clase
				//Ignoramos este error
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

	public String classFileNameInvert(String folderPath, Class clazz, String nameExtension, String extension) {
		String className = nameExtension.concat(clazz.getName().toLowerCase());
		return folderPath.concat(className.concat(extension));
	}

	public String getCSharpType(String type) {
		String returnType = "";
		switch (type) {
		case "char":
		case "varchar":
		case "text":
			returnType = "string";
			break;

		case "int":
			returnType = "int";
			break;
		case "time":
		case "date":
		case "datetime":
			returnType = "double"; //aca estaba decimal, pero reemplazamos por double
			break;
		case "float":
			returnType = "float";
			break;

		default:
			break;
		}

		return returnType;
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

	public String getSqliteProperties(String dataType, Boolean notNull, Integer size, Boolean unique,
			String defaultValue, String checkCondition) {
		String result = null;

		result = " " + dataType;

		if (size > 0 && dataType.equals("char")) // solo el tipo CHAR tiene este
													// formato Char(5)
			result = result + "(" + String.valueOf(size) + ")";

		if (notNull)
			result = result + " NOT NULL ";

		if (unique)
			result = result + " UNIQUE ";

		if (defaultValue != null)
			result = result + " DEFAULT " + defaultValue + " ";

		if (checkCondition != null)
			result = result + " CHECK (" + checkCondition + ")";

		return result;
	}
	
	//--- Crea la inicializacion de los constructores, recibiendo como parametros de entrada los cursores. Utilizado en los DAOs

	public String getConstructorDescription(String dataType, String value) {
		String result = value;
		
		switch (dataType) {
		//JAVA
		case "Integer":
			result = "Integer.parseInt(" + result + ")";
			break;
		case "Float":
			result = "Float.parseFloat(" + result + ")";
			break;
		case "BigDecimal":
			result = "new BigDecimal(" + result + ")";
			break;
		//C#
		case "int":
			result = "Int32.Parse(" + result + ")";
			break;
		case "double"://aca estaba decimal, pero reemplazamos por double
			result = "double.Parse(" + result + ", System.Globalization.CultureInfo.InvariantCulture)";
			break;
		case "float":
			result = "float.Parse(" + result + ", CultureInfo.InvariantCulture.NumberFormat)";
			break;
		default:
			break;
		}
		
		return result;
	}
	
	//--- Permite la inicializacion de los constructores tomando como parametro de entrada los valores recibidos del sharedpreferences
	
	public String getKVConstructorDescription(String javaDataType, String propertyName) {
		String result = propertyName+" == null ? \"\" : ";
		if (javaDataType.equals("Integer"))
			result += "Integer.parseInt(" + propertyName + ")";
		else if (javaDataType.equals("Float"))
			result += "Float.parseFloat(" + propertyName + ")";
		else if (javaDataType.equals("BigDecimal"))
			result += "new BigDecimal(" + propertyName + ")";
		else //tipo string
			result += propertyName;

		return result;
	}
	

	public String stringToSpecificTypeAssignment(String type, String value, String propertyName) {
		String result = "";

		switch (type) {
		case "Integer":
			result = type + " " + propertyName + " = " + "Integer.valueOf(" + value + ")";
			break;
		case "BigDecimal":
			result = type + " " + propertyName + " = " + "new BigDecimal(" + value + ")";
			break;
		case "Float":
			result = type + " " + propertyName + " = " + "Float.valueOf(" + value + ")";
			break;
		default:

		}

		return result;
	}

}
