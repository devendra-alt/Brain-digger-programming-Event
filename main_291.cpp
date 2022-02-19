#include <iostream>
using namespace std;
class Pattern
{
public:
    void draw()
    {
        for (int i = 1; i <= 5; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                if (i % 2 == 0)
                {
                    if (i == 2 && j == 5)
                    {
                        cout << "*";
                    }
                    else if (i == 2)
                    {
                        cout << " ";
                    }
                    if (i == 4 && j == 0)
                    {
                        cout << "*";
                    }
                    else if (i == 4)
                    {
                        cout << " ";
                    }
                }
                else
                {
                    cout << "*";
                }
            }
            cout << "\n";
        }
    }
};
int main()
{
    Pattern pattern;
    pattern.draw();
}