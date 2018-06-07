/*
 * Copyright 2018 Antoine PURNELLE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.ouftech.jokesprovider;

public class JokesProvider {

    public JokesProvider() {
    }

    /**
     * Return the joke corresponding to the provided number
     *
     * @param jokeNumber Number of the joke. Must be between 0 and 9
     * @return joke corresponding to the provided number
     */
    public String getJoke(int jokeNumber) {
        if (jokeNumber < 0 || jokeNumber > jokes.length)
            return "404 Joke not found";

        return jokes[jokeNumber];
    }

    // Provided by https://www.scandit.com/top-10-geek-jokes-for-developers/
    private static final String[] jokes =
            {
                    "Q: how many programmers does it take to change a light bulb?\n" +
                            "A: none, that\'s a hardware problem",

                    "To understand what recursion is, you must first understand recursion.",

                    "Q. How did the programmer die in the shower?\n" +
                            "A. He read the shampoo bottle instructions: Lather. Rinse. Repeat.",

                    "3 Database Admins walked into a NoSQL bar. A little while later they walked out because they couldn\'t find a table.",

                    "Q: Do you know why Facebook went public?\n" +
                            "A: They couldn\'t figure out the privacy settings!",

                    "Q: How do you explain the movie Inception to a programmer?\n" +
                            "A: Basically, when you run a VM inside another VM, inside another VM, inside another VM..., everything runs real slow!",

                    "An engineer, a manager, and a programmer are riding in a car. They come to a hill and their brakes fail. After careening down the hill and finally coming to a stop they get out to decide what to do. The manager says \"We need to have a meeting to form a committee to see what we should do next!\" The engineer says, \"Screw that! Give me a pocket knife and some duck tape and I\'ll have us going in no time!\" The programmer looks at them both and says, \"Lets push it back to the top and see if it does it again.\"",

                    "An int, a char and a string walk into a bar and order some drinks. A short while later, the int and char start hitting on the waitress who gets very uncomfortable and walks away. The string walks up to the waitress and says \"You\'ll have to forgive them, they\'re primitive types.\"",

                    "\"Knock, knock.\"\n" +
                            "\n" +
                            "\"Who\'s there?\"\n" +
                            "\n" +
                            "very long pause...\n" +
                            "\n" +
                            "\"Internet Explorer.\"",

                    "A programmer\'s wife sends him to the grocery store with the instructions, \"get a loaf of bread, and if they have eggs, get a dozen.\" He comes home with a dozen loaf of bread and tells her, \"they had eggs.\""
            };
}
