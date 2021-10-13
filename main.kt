fun main()
{
    // this section must be defined
    val dl: Int = 2
    val dh: Int = 1000

    var max_result = 0
    var max_index = 0
    for (i in dl..dh)
    {
        // we need to determine two things: was this remainder used before, and if so, when
        // e.g. for 0,1(09)09... answer is 2, not 3
        var used = IntArray(i + 1) { 0 }
        used[0] = Int.MAX_VALUE

        var value: Int = 1
        var counter: Int = 0
        while (used[value] == 0)
        {
            used[value] = counter
            while (value < i)
            {
                value *= 10
            }
            value %= i
            counter++
        }
        counter -= used[value]
        if (counter > max_result)
        {
            max_result = counter
            max_index = i
        }
    }
    println("$max_index $max_result")
}