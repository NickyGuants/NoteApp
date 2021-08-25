package com.nicky.noteapp

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses() {
        var course = CourseInfo(courseId = "Android_intents",title = "intents in android")
        courses.set(course.courseId, course)

        course = CourseInfo(courseId = "android_async", title = "android async tutorial")
        courses.set(course.courseId, course)

        course = CourseInfo(courseId = "Android_architecture", title = "architecture in android apps")
        courses.set(course.courseId, course)


    }
    private fun initializeNotes() {

        var course = courses["android_async"]
        var note = NoteInfo(course, "Service default threads",
            "Did you know that by default an Android Service will tie up the UI thread?")
        notes.add(note)

        note = NoteInfo(course, "Long running operations",
            "Foreground Services can be tied to a notification icon")
        notes.add(note)

        course = courses["Android_architecture"]
        note = NoteInfo(course, "user interface",
            "The UI consists of a fragment, UserProfileFragment, and its corresponding layout file, user_profile_layout.xml.")
        notes.add(note)
        note = NoteInfo(course, "user experience",
            "In the majority of cases, desktop apps have a single entry point from a desktop or program launcher, then run as a single, monolithic process.")
        notes.add(note)
        note = NoteInfo(course, "Connect ViewModel and the repository",
            "Now, we modify our UserProfileViewModel to use the UserRepository object")
        notes.add(note)

        course = courses["Android_intents"]
        note = NoteInfo(course, "Dynamic intent resolution",
            "Wow, intents allow components to be resolved at runtime")
        notes.add(note)
        note = NoteInfo(course, "Delegating intents",
            "PendingIntents are powerful; they delegate much more than just a component invocation")
        notes.add(note)
    }

}