package jobs

import org.apache.hadoop.fs.Path

class StackExchangeBatchJob extends JobsMediator {

  def main(path: Path) = {
    userProcessors(path)
  }
}
