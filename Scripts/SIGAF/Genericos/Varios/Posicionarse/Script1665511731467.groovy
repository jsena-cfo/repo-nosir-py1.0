import org.sikuli.script.*
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Integer x= this.getBinding().getAt('varX').toString().toInteger()
Integer y= this.getBinding().getAt('varY').toString().toInteger()
Integer w= this.getBinding().getAt('varW').toString().toInteger()
Integer h= this.getBinding().getAt('varH').toString().toInteger()

Screen screen= new Screen()

screen.hover(new Region(x,y,w,h))