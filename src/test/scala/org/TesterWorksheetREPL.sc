case class ConditionalClass(
                           value1:String,
                           value2:String,
                           value3: Option[String]=null
                           )


import org.apache.arrow.vector.types.pojo.ArrowType.ComplexType

import scala.reflect.runtime.universe._


println(classOf[ConditionalClass]
  .getDeclaredFields
  .map{ f =>
    f.setAccessible(true)
    val res = f.getName
    f.setAccessible(false)
    res
  }.toSeq)

import scala.reflect.runtime.universe._


def classAccessors[T: TypeTag]: List[String] = typeOf[T].members.collect {
  case m: MethodSymbol if m.isCaseAccessor => m}
  .toList.map(s => s.name.toString)

val typeComplexFields = classAccessors[ComplexType]
val newDataFrame = simpleDF
  .select(typeComplexFields
    .map(c => if (simpleDF.columns.contains(c)) col(c) else lit(null).as(c)) : _*)
  .as[ComplexType]


val values = ("cust_ID","Account_ID",
  123244)
val values2 = ("cust_ID","Account_ID")

//println((ConditionalClass.apply _).tupled(values))

val a = ConditionalClass("", "")
val b = a.copy(value3=Some(12345))
println(a)
println(b)
//values2.copy()

//println((ConditionalClass.apply _).tupled(values2))