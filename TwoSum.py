def two_sum(arr, target):
    res = {}
    for i in range(0, len(arr)):
        cont = target - arr[i]
        if cont in res:
            return [i, res[cont]]
        res[arr[i]] = i


print two_sum([2,7,11,15], 9)