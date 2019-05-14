import scala.reflect.runtime.{universe => runTimeUniverse}

def getCaseClassType[T: runTimeUniverse.TypeTag]
: List[runTimeUniverse.Symbol] = {
  runTimeUniverse.typeOf[T].members.toList
}

def getMembers[nameCaseClass: runTimeUniverse.TypeTag]: List[String] = {
  getCaseClassType[nameCaseClass]
    .filter(!_.isMethod)
    .map(x => x.name.decodedName.toString.replaceAll(" ", ""))

}

case class neTypeCaseClass(
                          value1:Int,
                          Value2:String
                          )


println(getMembers[neTypeCaseClass])
//val newStack = new StackExchangeBatchJob("/home/abhishekv11/Desktop")

//println(newStack.main(Array("newPath")))