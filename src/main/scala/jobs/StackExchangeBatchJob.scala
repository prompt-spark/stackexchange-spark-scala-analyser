package jobs

import io.ioSchema.StackExchangeInputSchema
import org.apache.spark.sql.Dataset


object StackExchangeBatchJob extends JobsMediator {

  def main(path: String) = {
    userModelProcessors(path)
    postModelProcessors(path)
  }
}
