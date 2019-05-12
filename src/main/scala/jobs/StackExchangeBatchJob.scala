package jobs

import io.ioSchema.StackExchangeInputSchema
import org.apache.spark.sql.Dataset


class StackExchangeBatchJob extends JobsMediator {

  def main(path: String): Dataset[StackExchangeInputSchema.UsersData] = {
    userProcessors(path)
  }
}
