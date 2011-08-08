package org.elasticmq.rest.sqs

import org.jboss.netty.logging.{Log4JLoggerFactory, InternalLoggerFactory}
import org.apache.log4j.{BasicConfigurator}
import org.elasticmq.NodeBuilder

object SQSManualTesting {
  def main(args: Array[String]) {
    BasicConfigurator.configure();
    InternalLoggerFactory.setDefaultFactory(new Log4JLoggerFactory())

    val node = NodeBuilder.createNode
    val client = node.nativeClient

    val server = new SQSRestServerFactory(client, 8888, "http://localhost:8888").start()
    println("Started")
    readLine()
    server.stop()
    node.shutdown()
    println("Stopped")
  }
}