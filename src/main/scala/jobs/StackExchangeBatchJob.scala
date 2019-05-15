/*
 * Copyright © 2019 Abhishek Verma (abhishekv3007@gmail.com)
 *
 *                    GNU AFFERO GENERAL PUBLIC LICENSE
 *                       Version 3, 19 November 2007
 * Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 *                            Preamble
 *
 *   The GNU Affero General Public License is a free, copyleft license for
 * software and other kinds of works, specifically designed to ensure
 * cooperation with the community in the case of network server software.
 *
 *   The licenses for most software and other practical works are designed
 * to take away your freedom to share and change the works.  By contrast,
 * our General Public Licenses are intended to guarantee your freedom to
 * share and change all versions of a program--to make sure it remains free
 * software for all its users.
 */

package jobs

import api.JobsMediator

object StackExchangeBatchJob extends JobsMediator {

  private val APP_NAME = getClass.getSimpleName
  private val INPUT_PATH = "input_path"
  private val OUTPUT_PATH = "output_path"

  case class Config(
      inputPath: String = "",
      outputPath: String = ""
  )

  def parseArgs(args: Array[String]): Config = {

    val parser = new scopt.OptionParser[Config](APP_NAME) {
      head(APP_NAME)

      opt[String](INPUT_PATH)
        .action((x, c) => c.copy(inputPath = x))
        .required()
        .text("Input Path for XML files")

      opt[String](OUTPUT_PATH)
        .action((x, c) => c.copy(outputPath = x))
        .required()
        .text("Path for saving JSON and Parquet file")

    }

    parser.parse(args, Config()) match {
      case Some(config) => config
      case None =>
        println("Illegal arguments.")
        sys.exit(0)
    }
  }

  def main(args: Array[String]): Unit = {
    val config = parseArgs(args)

    val inputPath = config.inputPath
    val outputPath = config.outputPath

    batchjobRun(inputPath, outputPath)

  }

  def batchjobRun(inputPath: String, outputPath: String): Long = {
    postModelProcessors(inputPath, outputPath)
  }

}
