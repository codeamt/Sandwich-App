<h1 align="center"><a href="https://sites.google.com/udacity.com/gwgdevscholarship/home">#GrowWithGoogle</a> Android Development Project: <br>Sandwich App</h1>

To kick off Phase 2 of the Grow With Google Developer Scholarship Program and conjointly Udacity's Nanodegree Program for Android Development, students were asked to complete a mobile app (written in Java) that holds details about famous sandwiches from around the world. 

Here's my go at it:

<p align="center">
  <img src="https://ucarecdn.com/a9806071-c380-4c52-aa0d-26777c5658ac/">
</p>

## Udacity's Learning Objectives  
- [x] Practicing JSON parsing to a model object 
- [x] Design an activity layout
- [x] Populate all fields in the layout accordingly 


## Core Functionality:  


#### Data Parsing 
The primary goal for completing this project was to parse sandwich details from a string array (located in the string values resource file) and: 

- make a JSON copy of each sandwich that maps sandwich details to object keys, then 
- serializes this JSON to a Java object in accordance with an existing Sandwich model 

Instead of using a 3rd party library to realize this goal, we implemented this functionality from scratch by defining a globally accessible method in JSONUtils that converts sandwich strings to JSON objects like a factory. 

(A great learning experience!) 


#### Data Binding 

The user journey for this app goes as follows: 

- Click on a sandwich name
- See details page for more info about that particular sandwich. 


With this in mind, the second goal of this project was to bind Sandwich data to the child views of their retlative Detail Activity UIs

To achieve this, the JSON conversion method is called from inside a click listener. When a sandwich name is clicked, the Detail View's fragments are inflated and populated.  

Some of the keys on these sandwhich objects hold arrays of items (e.g., ingredients or alternative names). A helper method concats and formats these list items, as needed, before binding them to their UIs.


#### Responsive Layout  
The third goal for this project was to build out a sensible layout for the Details Activity UI. I implemented a tabbed layout and nested Scroll Views within these tabs to make details viewable on smaller devices. 

Attending to landscape mode, I made a horizontal layout that put feature image and details side-by-side. 

<p align="center">
  <img src="https://ucarecdn.com/0e40db9b-271a-457f-8935-21462c99f2eb/" >
</p>

I hope to get better at Front End work after completing the upcoming course on Material Design. 

## Versioning and Dependencies 

**Target SDK Version:** 26

**Dependencies:**
- com.android.support.constraint:constraint-layout:1.0.2
- com.android.support:appcompat-v7:26.1.0
- com.android.support:design:26.1.0
- com.squareup.picasso:picasso:2.5.2

**Android Studio Version:** 3.1.2 (Stable Release)

**Gradle Version:** 3.0.1
