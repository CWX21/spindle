///////////////////////////////////////////////////////////////////////////
//
// Copyright (c) 2014 Adobe Systems Incorporated. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
///////////////////////////////////////////////////////////////////////////

package com.adobe

// Scala.
import scala.collection.mutable.ArrayBuffer

// Akka and Spray
import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http

object QueryApp {
	def main(args: Array[String]) {
    implicit val system = ActorSystem.create("query")
    val handler = system.actorOf(
      Props(classOf[QueryServiceActor]),
      name = "handler"
    )

    IO(Http) ! Http.Bind(handler, interface="0.0.0.0", port=8585)
  }
}
