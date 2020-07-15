%% Question 12, Section 3.2
%
% By _David Dobor_, CIS 2166 Recitation 2.
%
% Recall the solution to this problem that we did on board. In that solution 
% we showed that 
%
% $x^2$ is not $O(x \log x).$
%
% We showed this by assuming the above to be true and arriving at a 
% contradiction. We said that if the above claim were true, then we would 
% be able to find constants $C$ and $k$ such that 
%
% $$ \frac{x} { \log x } \leq C $$
%
% for all $x > k$ (we divided the inequality from the Big-O definition by $x$, which we can do since
% $k$ is assumed to be positive).
%
% But the above could not hold true because $\frac{x} { \log x }$ is an
% anbounded function of $x$ that would exceed any given constant $C$.
%
% We in turn justified the fact that $\frac{x} { \log x }$ is unbounded by noting
% that for sufficiently large $x$ (whenever $x > 16$) we have
%
% $$ \log x < \sqrt x $$
%
% and therefore 
%
% $$ \frac{x} { \log x } > \frac{x} {\sqrt x} = \sqrt x. $$
%
% From this it immediately followed that $\frac{x} { \log x }$ is unbounded 
% since $\sqrt x$ is clearly unbounded.
%
%
% *Now, here is a plot showing that*
%
% $$ \log x < \sqrt x $$
%
% whenever $x > 16.$
%
%%
x = linspace(1, 60, 500);
y1 = log2(x);
y2 = sqrt(x);
plot(x,y1, 'b', x, y2, 'g', 'linewidth', 2)
title('Demo that $$\sqrt x$$ eventually exceeds $$\log x$$','interpreter','latex') 
legend({'log x', '$\sqrt x$'},'Location','northwest','interpreter','latex') 
x = linspace(1, 60, 500);
y1 = log2(x);
y2 = sqrt(x);
plot(x,y1, 'b', x, y2, 'g', 'linewidth', 2)
title('Demo that $$\sqrt x$$ eventually exceeds $$\log x$$','interpreter','latex') 
legend({'log x', '$\sqrt x$'},'Location','northwest','interpreter','latex') 

%% 
% *Optional Exercise*
%
% Plot 
%
% $$ y = \frac{x} { \log x }$$
%
%
% Does it appear unbounded? 
%
% This is all we need to know to conclude that 
%
% $x^2$ is not $O(x \log x).$
%
% 
%
%%
%
% *Solution to Optional Exercise*
%
x = linspace(1, 50, 500);
y = x ./ log2(x);
plot(x,y, 'linewidth', 2)
title('Plot of  $$ y = \frac{x} { \log x }$$','interpreter','latex') 

