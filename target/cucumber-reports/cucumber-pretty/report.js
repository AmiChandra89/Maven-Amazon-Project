$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Camera.feature");
formatter.feature({
  "line": 1,
  "name": "Finding a Nikon Camera on Amazon.com",
  "description": "",
  "id": "finding-a-nikon-camera-on-amazon.com",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3321016167,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Find Nikon Camera and assert if Nikon D3x is present",
  "description": "",
  "id": "finding-a-nikon-camera-on-amazon.com;find-nikon-camera-and-assert-if-nikon-d3x-is-present",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": ": The user is able to navigate to \"https://www.amazon.com\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": ": User tried to search \"Nikon\" in search filter and sort in \"ascending\" order",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": ": Verify the seller brand",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": ": Verify that the second entry is \"Nikon D3X\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.amazon.com",
      "offset": 35
    }
  ],
  "location": "CameraSteps.the_user_is_able_to_navigate_to(String)"
});
formatter.result({
  "duration": 2759264588,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Nikon",
      "offset": 24
    },
    {
      "val": "ascending",
      "offset": 61
    }
  ],
  "location": "CameraSteps.user_tried_to_search_in_search_filter_and_sort_in_order(String,String)"
});
formatter.result({
  "duration": 4162827945,
  "status": "passed"
});
formatter.match({
  "location": "CameraSteps.verify_the_seller_brand()"
});
formatter.result({
  "duration": 13279170035,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Nikon D3X",
      "offset": 35
    }
  ],
  "location": "CameraSteps.verify_that_the_second_entry_is(String)"
});
formatter.result({
  "duration": 20137177999,
  "error_message": "java.lang.AssertionError: expected [true] but found [false]\r\n\tat org.testng.Assert.fail(Assert.java:96)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:776)\r\n\tat org.testng.Assert.assertTrue(Assert.java:44)\r\n\tat org.testng.Assert.assertTrue(Assert.java:54)\r\n\tat com.cucumber.bdd.steps.CameraSteps.verify_that_the_second_entry_is(CameraSteps.java:61)\r\n\tat ✽.Then : Verify that the second entry is \"Nikon D3X\"(features/Camera.feature:7)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 1130918766,
  "status": "passed"
});
});