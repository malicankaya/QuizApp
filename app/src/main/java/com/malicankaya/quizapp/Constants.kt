package com.malicankaya.quizapp

object Constants {
    private var question: String = "What country does this flag belong to?"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            question,
            R.drawable.ic_flag_of_argentina,
            "Argentina","Australia",
            "Armenia","Austria",
            1
        )
        questionsList.add(que1)

        val que2 = Question(
            2,
            question,
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia",
            3
        )
        questionsList.add(que2)

        // 3
        val que3 = Question(
            10,
            question,
            R.drawable.ic_flag_of_turkiye,
            "Syria", "Tuvalu",
            "Turkiye", "Azerbaijan", 1
        )

        questionsList.add(que3)
        // 4
        val que4 = Question(
            4,
            question,
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5,
            question,
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6,
            question,
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7,
            question,
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8,
            question,
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9,
            question,
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10,
            question,
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )

        questionsList.add(que10)

        // 11
        val que11 = Question(
            3,
            question,
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil",
            4
        )
        questionsList.add(que11)

        return questionsList
    }
}