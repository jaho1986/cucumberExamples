Feature: Create, update and deleting post in REST API.

  @readonly-scenarios
  Scenario Outline: Playing with the route /posts in the API
    Given The list of posts in the route /posts
    Then I am going to get 100 results
    And It should contains the following title: nesciunt quas odio
    Given The following Posts <ok_ids> to the endpoint /posts
    Then I should get a <response_ok> status
    But If I try to get this 999 Id in /posts I should get 404

    Examples: IDs of different posts that are stored
      | ok_ids | response_ok |
      | 1      | 200         |
      | 2      | 200         |
      | 3      | 200         |

  @readonly-scenarios
  Scenario Outline: Validating 404 status code
    Given These <bad_ids> post ids
    Then All of them should response <response_bad>

    Examples: IDs of different posts that are not stored
      | bad_ids | response_bad |
      | 1001    | 404          |
      | 2001    | 404          |
      | 3001    | 404          |

  @modifying-info
  Scenario: Validating POST, DELETE and PUT
    Given The following post_test.json file at /posts URI
    Then It should receive a 201 status code
    And I sleep for 1 second
    When I update the post at /posts URI
    Then In /posts with id 1 I should see the following title: sunt aut facere repellat provident occaecati excepturi optio reprehenderit
    When I delete the user 1 at /posts URI
    Then I should get a 404 status if I try to obtain the 1999 in /post again