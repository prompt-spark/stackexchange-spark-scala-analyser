case class ConditionalClass(
                           value1:String,
                           value2:String,
                           value3: Option[Int]=null
                           )



val values = ("cust_ID","Account_ID",
  123244)
val values2 = ("cust_ID","Account_ID")

//println((ConditionalClass.apply _).tupled(values))

val a = ConditionalClass(value1 = "", value2 = "")
val b = a.copy(value3=Some(12345))
println(a)
println(b)
//values2.copy()

//println((ConditionalClass.apply _).tupled(values2))