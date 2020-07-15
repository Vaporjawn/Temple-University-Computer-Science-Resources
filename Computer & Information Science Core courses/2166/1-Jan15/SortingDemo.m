%% Two Sorting Agorithms: Bubble-Sort and Selection-Sort
%
% _David Dobor_  
%
% CIS 2166, Recitation 1, Spring 2016
%
% 
%
% The psedocode found in Rosen's textbook, pp 198-199 (seventh edition), is
% translated into matlab and shown below. 
%
%% Bubble sort 
%%
%  function x = bubblesort(x)
%  n = length(x);
%  for i = 1:n-1  %number of passes
%      for j = 1:n-i
%          % Swap elements if they are in wrong order
%          if (x(j) > x(j + 1))
%              x = swap(x,j,j + 1);
%          end
%      end
%      fprintf('Pass %i: \n', i)
%      fprintf('\t%d ', x)
%      fprintf('\n\n')
%  end
%  end
%
%  function x = swap(x,i,j)
%  % Swap x(i) and x(j)
%  % Note: In practice, x xhould be passed by reference
%
%  val = x(i);
%  x(i) = x(j);
%  x(j) = val;
%
%  end
%  

fprintf('\nExample on page 197 of the textbook:\n')
unsorted = [3, 2, 4, 1, 5]
sorted = bubblesort(unsorted)

fprintf('\nSolution to problem 34, Section 3.1:\n')
unsorted1 = [6, 2, 3, 1, 5, 4]
sorted1 = bubblesort(unsorted1)

%% Insertion Sort
%
% To sort a list of n elements, insertion sort begins with the second
% element, compares it with the first element and puts it in the correct
% position (that is, if the first element was smaller,the second element
% stays in its position, otherwise the first and the second elements are
% exchanged). At this point the first two elements are in correct order. At the
% next iteration, the third element is compared to the first element. If it
% is larger than the first element, it is compared with the second element.
% The third element is then inserted into its correct position among the
% first 3 elements.
%
% The algorithm continues so that at the j-th step of the algorithm, the
% j-th element is inserted into its correct position among the previously
% sorted j-1 elements. Thus at the end of the j-th iteration, the first j
% elements have been insertion-sorted. The invariant here is that
% everything to the left of the element currently being considered is
% already sorted.  
%
%
%%
%  function x = insertionsort(x)
%  n = length(x);
%  for j = 2:n
%      current = x(j);
%      i = j;
%      while ((i > 1) && (x(i - 1) > current))
%          x(i) = x(i - 1);
%          i = i - 1;
%      end
%      x(i) = current;
%  end
%  end
%  

unsorted2 = [7, 10, 5, 3, 8, 4, 2, 9, 6]
insertionsort(unsorted2)

%% 
%
%
% <https://www.youtube.com/watch?v=v3-5usEcnog Selection Sort> 