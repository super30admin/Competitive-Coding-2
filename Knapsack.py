'''
    Time Complexity:
        O(mn) (where m = length of weights, n = max_weight)

    Space Complexity:
        O(mn) (where m = number of items, n = max_weight)

    Did this code successfully run on LeetCode?:
        Couldn't find it on LeetCode.

    Problems faced while coding this:
        None

    Approach:
        Top Down Memoization approach
        -> Start with give capacity and first item.
        -> At each step, you have two options:
            -> Ignore this item and go to another the next item
            -> If weight of this item <= your current capacity,
                you can choose this item and go to the next.
                Your weight now decreases by the weight of this item.
                And you get the value of this item.
            -> The max of these two is your ans.
        Memoize it.
'''
values = [60, 100, 120]
weights = [10, 20, 30]
max_weight = 50
dp = {}

def knap_sack(w, i):
    if (w, i) in dp:
        return dp[(w, i)]

    if i >= len(weights):
        return 0

    ignore = knap_sack(w, i + 1)
    if weights[i] > w:
        dp[(w, i)] = ignore
    else:
        select = values[i] + knap_sack(w - weights[i], i + 1)
        dp[(w, i)] = max(select, ignore)

    return dp[(w, i)]

print(knap_sack(max_weight, 0))
