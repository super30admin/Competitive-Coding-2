# Time Complexity: O(1)
# Space Complexity: O(1) # Because the length of the number and all the created arrays are fixed.
class Solution(object):
    def __init__(self):
        self.tens = ['', 'Ten', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']
        self.below_20 = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']
        self.suffix = ['', 'Thousand', 'Million', 'Billion']
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return 'Zero'
        place = 0
        result = ''
        while num > 0:
            val = strip(self.helper(num%1000))
            if val != '':
                result = val +' '+self.suffix[place] + ' '+result
            num /= 1000
            place += 1
        return strip(result)
            
    def helper(self, num):
        if num == 0:
            return ''
        if num < 20:
            return self.below_20[num] + ' '
        elif num < 100:
            return self.tens[num/10] + ' '+ self.below_20[num%10]
        else:
            return self.below_20[num/100]+ ' Hundred '+self.helper(num%100) 
            
