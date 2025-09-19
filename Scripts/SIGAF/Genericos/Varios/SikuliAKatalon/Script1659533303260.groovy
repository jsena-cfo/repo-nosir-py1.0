import java.nio.file.Files
import java.nio.file.Paths
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils
//import internal.GlobalVariable


pathSikuli = pathSikuli.replace('\\','\\\\')
def pathArchivoPy = ''
if(pathSikuli.contains('/')) {
	nombreArchivo = pathSikuli.substring(pathSikuli.lastIndexOf("/") + 1)
	pathArchivoPy = Paths.get(pathSikuli + '/' + nombreArchivo + '.py')
}
else {
	nombreArchivo = pathSikuli.substring(pathSikuli.lastIndexOf("\\") + 1)
	pathArchivoPy = Paths.get(pathSikuli + '\\' + nombreArchivo + '.py')
}
List<String> lines = Files.readAllLines(pathArchivoPy)

println('\n\n\nimport org.sikuli.script.*\nimport com.kms.katalon.core.util.KeywordUtil\nimport internal.GlobalVariable as GlobalVariable\n\n\n\nScreen screen = new Screen()\n\n')

for (String line : lines) {
    if (line != '') {
        line = ('screen.' + line)
        try {
            if (line.contains('Pattern')) {
                line = line.replaceAll('Pattern', 'new Pattern')
				String smallString = StringUtils.substringBetween(line, 'Pattern(', '.png"')		
				def stringNuevo = 'pathImagen(' + smallString
				line = line.replace(smallString, stringNuevo)
				line = line.replace('.png"', '.png")')
            } else {
                String smallString = StringUtils.substringBetween(line, '(', '.png"')
                def stringNuevo = 'pathImagen(' + smallString
                line = line.replace(smallString, stringNuevo)
                line = line.replace('.png"', '.png")')
            }
            println(line)
        }
        catch (Exception e) {
            println(line)
        } 
    }
}

testCaseActual = GlobalVariable.testCaseActual
testCaseActual = testCaseActual.substring(testCaseActual.lastIndexOf("/") + 1)
def pathEnKatalon = System.getProperty('user.dir') + '\\Image Repository\\'+ testCaseActual
pathEnKatalon = pathEnKatalon.replace('\\','\\\\')

println('\ndef pathImagen(String nombreimagen) {\n    def path = System.getProperty(\'user.dir\') + \'\\\\Image Repository\\\\' + testCaseActual + '\\\\\'\n\n    nombreimagen = (path + nombreimagen)\n\n    KeywordUtil.logInfo(\'ruta imagen: \' + nombreimagen)\n\n    return nombreimagen\n}\n\n\n\n')


File src = new File(pathSikuli);
File dest = new File(pathEnKatalon);

if (dest.isDirectory()) {
	String[]entries = dest.list();
	for(String s: entries){
		File currentFile = new File(dest.getPath(),s);
		currentFile.delete();
	}
}
try {
	FileUtils.copyDirectory(src, dest);
} catch (IOException e) {
	e.printStackTrace();
}