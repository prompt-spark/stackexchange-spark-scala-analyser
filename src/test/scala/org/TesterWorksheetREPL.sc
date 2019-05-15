import scala.util.Try

val l: Either[String, String] = Left("json"),Right("parquet")

for (s <- l.left) yield s.size