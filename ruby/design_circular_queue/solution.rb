class MyCircularQueue
=begin
    :type k: Integer
=end
  def initialize(k)
    @k = k
    @ary = Array.new(k) # initialize an empty buffer
    @front = 0
    @count = 0
  end

=begin
    :type value: Integer
    :rtype: Boolean
=end
  def en_queue(value)
    return false if is_full
    idx = (@front + @count) % @k
    @ary[idx] = value
    @count += 1
    true
  end

=begin
    :rtype: Boolean
=end
  def de_queue()
    return false if is_empty
    val = @ary[@front]
    @front = (@front + 1) % @k
    @count -= 1
    return true
  end

=begin
    :rtype: Integer
=end
  def front()
    return -1 if is_empty
    @ary[@front]
  end

=begin
    :rtype: Integer
=end
  def rear()
    return -1 if is_empty
    @ary[(@front + @count - 1) % @k]
  end

=begin
    :rtype: Boolean
=end
  def is_empty()
    @count == 0
  end

=begin
    :rtype: Boolean
=end
  def is_full()
    @k == @count
  end
end

# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue.new(k)
# param_1 = obj.en_queue(value)
# param_2 = obj.de_queue()
# param_3 = obj.front()
# param_4 = obj.rear()
# param_5 = obj.is_empty()
# param_6 = obj.is_full()