Peripatetic Shipping Lines, inc., is a shipping company that owns n ships
and provides service to n ports. Each of its ships has a schedule that says,
for each day of the month, which of the ports it’s currently visiting, or
whether it’s out at sea. (You can assume the "month" here has m days,
for some m > n.) Each ship visits each port for exactly one day during the
month. For safety reasons, PSL Inc. has the following strict requirement:
(t) No two ships can be in the same port on the same day.
The company wants to perform maintenance on all the ships this
month, via the following scheme. They want to truncate each ship’s
schedule: for each ship Sg, there will be some day when it arrives in its
scheduled port and simply remains there for the rest of the month (for
maintenance). This means that Si will not visit the remaining ports on
its schedule (if any) that month, but this is okay. So the truncation of
Si’s schedule will simply consist of its original schedule up to a certain
specified day on which it is in a port P; the remainder of the truncated
schedule simply has it remain in port P.
Now the company’s question to you is the following: Given the sched-
ule for each ship, find a truncation of each so that condition (t) continues
to hold: no two ships are ever in the same port on the same day.
Show that such a set of truncations can always be found, and give an
algorithm to find them.

Example. Suppose we have two ships and two ports, and the "month" has
four days. Suppose the first ship’s schedule is

port P1; at sea; port P2; at sea

and the second ship’s schedule is

at sea; port P1; at sea; port P2

Then the (only) way to choose truncations would be to have the first ship
remain in port Pz starting on day 3, and have the second ship remain in
port P1 starting on day 2.

Algorithm Design by Jon Kleinberg and Éva Tardos
