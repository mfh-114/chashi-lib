[![Build Status](https://travis-ci.org/mfh-114/chashi-lib.svg?branch=master)](https://travis-ci.org/mfh-114/chashi-lib) [![codecov](https://codecov.io/gh/mfh-114/chashi-lib/branch/master/graph/badge.svg)](https://codecov.io/gh/mfh-114/chashi-lib)

# chashi-lib

It is a topological sort library with optional event handler. In Bengali, chashsi means farmer. According to the wikipedia, "A farmer is a person engaged in agriculture, raising living organism for food and raw material."   

This library is engaged to produce food (refined data) for the dedicated business environment. For example, a college student may have multiple courses per semester. The student need to know which course needs pre-required courses to meet the requirement of the specific course. Therefore, a student needs to know the sorted order of courses. In this case, the student will produce a course graph and each course is a vertex and feed the graph data into this library. The library will return the sorted order of the courses. Now, the student can add event for each course, optionally. Like, when course A is sorted, trigger course registration event and fetch the syllabus of the course. In the complex scenario, course A and B are sorted but course C depends on course A and B. Therefore, course C's event (if event is registered) will be waiting until course A and B events' are completed.  

In sort sentence, this library returns sorted vertexes of a graph. Event of the vertex will be triggered asynchronously, if event is registered.  

###How to use:
####TODO:.......
