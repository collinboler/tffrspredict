# How to use:

# Refreshing an event leaderboard:
- copy and paste tffrs leaderboard of specific event into raw.txt
- run Refresh.java and enter specific event when prompted

# Running Predictions:
- run Analysis.java and enter specific event when prompted
- results will appear in Results.txt and in the terminal

# How it works:
- Produces a new event leaderboard that excludes people who are ranked higher on
  another list.
- When analyzing 5k, program ignores 10k entries. (to improve accuracy)
- Will develop a better 5K 10K algorithm through more analysis

# Analysis
performs the same as Tffrs but outputs the list of predicted scratches for each event alongside the predicted qualifying list.

Run it by adding the event you want to the command line argument:
Ex: java Analysis 5000

More updates coming soon

# 2023 Prediction Accuracy
event     | predicted #48       | actual #48  |   score
800       |   Harris            | Harris      | (perfect)
1500      |   Becker            | Gabay       | (+1 place)
steeple   |   Ireland           |  Ireland    | (perfect)

accuracy for 800, 1500, and steeple basically perfect
event     | predicted #48       |  actual #48 | score
5000      |  McHanon            |   Gough     | (+7)
10000     |  Asfaw              |   Kirk      | (-1)

10000 is very good, 5k is too conservative

# a Collin Boler production


