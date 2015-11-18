# Hystrix-Spring Integration

Hystrix is a latency and fault tolerance library designed to isolate points of access to remote systems, services and 3rd party libraries, stop cascading failure and enable resilience in complex distributed systems where failure is inevitable.

Hystrix Commands can be synchronous (blocking calls) and asynchronous.

## Types of Commands

#### 1) Fail Fast Command. 
Throws an exception if any type of failure occurs.

#### 2) Fail Silent Command. 
Equivalent of returning an empty response or removing functionality in case of a failure.

#### 3) Commands with static/stubbed fallback. 
Return Default value in case of a failure.

Examples of places where you might find state appropriate to use in these stubbed values are: cookies, request arguments and headers, responses from previous service requests prior to the current one failing

#### 4) Commands with cached fallback. 
Return stale version of data from a cache service such as memcached.

